package com.tick.service.impl;

import com.tick.mapper.TaskMapper;
import com.tick.mapper.TickRecordMapper;
import com.tick.pojo.http.*;
import com.tick.pojo.mybatis.Task;
import com.tick.pojo.mybatis.TickRecord;
import com.tick.service.TickTaskService;
import com.tick.util.MybatisSupplier;
import com.tick.util.TDate;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class TickTaskServiceImpl implements TickTaskService {
    private static final Logger LOG = LoggerFactory.getLogger(TickTaskServiceImpl.class);

    @Override
    public GetTickTaskResponse requestTasks(GetTickTaskRequest request) {
        GetTickTaskResponse response = new GetTickTaskResponse();
        List<Map<String, Object>> responseUnits = new LinkedList<>();
        List<Task> tasks = getTasks(request.getTelephone());

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);

        for (Task task : tasks) {
            List<TickRecord> tickRecords = getTickRecords(task.getTaskId());
            GetTickTaskResponseUnit unit = new GetTickTaskResponseUnit();
            unit.setDate(task.getDate());
            unit.setDescribe(task.getDescribe());
            unit.setName(task.getName());
            unit.setPeriod(task.getPeriod());
            unit.setTickedToday(false);
            unit.setTaskId(task.getTaskId());

            List<String> tickDateList = new LinkedList<>();

            for (TickRecord record : tickRecords) {
                LOG.info("check record:{}", record.toString());
                LOG.info("check today:{}", today);
                tickDateList.add(record.getDate());
                if (record.getDate().equals(today)) {
                    unit.setTickedToday(true);
                }
            }
            unit.setTickedDate(tickDateList);
            responseUnits.add(unit.convert());
        }
        response.setMsg("get task success");
        response.setRetCode(0);
        response.setTasks(responseUnits);
        return response;
    }

    @Override
    public BaseResponse updateTask(UpdateTickTaskRequest request) {
        SqlSession session = new MybatisSupplier().get().getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        mapper.updateTickTask(request.getName(), request.getDescribe(), request.getPeriod(),
                TDate.format(request.getDate()), request.getId());
        session.close();
        BaseResponse response = new BaseResponse();
        response.setRetCode(0);
        response.setMsg("update task success");
        return response;
    }

    @Override
    public BaseResponse removeTask(RemoveTickTaskRequest request) {
        SqlSession session = new MybatisSupplier().get().getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        // 先删除任务
        mapper.deleteTickTask(request.getTaskId(), request.getTelephone());
        TickRecordMapper tickRecordMapper = session.getMapper(TickRecordMapper.class);
        // 再删除打卡记录
        tickRecordMapper.removeTaskTickRecord(request.getTaskId());
        session.close();

        BaseResponse response = new BaseResponse();
        response.setRetCode(0);
        response.setMsg("update task success");
        return response;
    }

    @Override
    public AddTickTaskResponse addTask(AddTickTaskRequest request) {
        SqlSession session = new MybatisSupplier().get().getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        Long id = mapper.addTickTask(request.getTelephone(), request.getName(), request.getDescribe(), request.getPeriod(), TDate.format(request.getDate()));
        session.close();
        AddTickTaskResponse response = new AddTickTaskResponse();
        response.setRetCode(0);
        response.setMsg("add task success");
        response.setId(id);
        return response;
    }

    @Override
    public BaseResponse updateTickRecord(UpdateTickRecordRequest request) {
        SqlSession session = new MybatisSupplier().get().getSession();
        TickRecordMapper mapper = session.getMapper(TickRecordMapper.class);
        if (request.getType().equals("remove")) {
            mapper.removeTickRecord(request.getTaskId(), TDate.format(request.getDate()));
        } else {
            mapper.addTickRecord(request.getTaskId(), TDate.format(request.getDate()));
        }
        BaseResponse response = new BaseResponse();
        response.setRetCode(0);
        response.setMsg("update tick task record success");
        return response;
    }

    private List<Task> getTasks(String telephone) {
        SqlSession session = new MybatisSupplier().get().getSession();
        TaskMapper mapper = session.getMapper(TaskMapper.class);
        List<Task> tasks = mapper.getTasks(telephone);
        session.close();


        return tasks;
    }

    private List<TickRecord> getTickRecords(Long taskId) {
        SqlSession session = new MybatisSupplier().get().getSession();
        TickRecordMapper mapper = session.getMapper(TickRecordMapper.class);
        List<TickRecord> tickRecords = mapper.getTickRecords(taskId);
        session.close();
        return tickRecords;
    }

}
