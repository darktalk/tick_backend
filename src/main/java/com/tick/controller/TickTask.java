package com.tick.controller;


import com.tick.pojo.http.*;
import com.tick.service.SessionService;
import com.tick.service.TickTaskService;
import com.tick.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TickTask {
    private static final Logger LOG = LoggerFactory.getLogger(TickTask.class);

    @Autowired
    private TickTaskService service;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(
            value = "/api/getTickTasks",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> getTickTasks(@RequestBody GetTickTaskRequest request) {
        Map<String, Object> checkSessionResponse = sessionService.checkSessionId(request.getSessionId(), request.getTelephone());
        if ((Integer)checkSessionResponse.get(Constant.retCode) != 0) {
            return checkSessionResponse;
        }
        GetTickTaskResponse response = service.requestTasks(request);
        return response.convert();
    }

    @RequestMapping(
            value = "/api/removeTickTask",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> removeTickTask(@RequestBody RemoveTickTaskRequest request) {
        Map<String, Object> checkSessionResponse = sessionService.checkSessionId(request.getSessionId(), request.getTelephone());
        if ((Integer)checkSessionResponse.get(Constant.retCode) != 0) {
            return checkSessionResponse;
        }
        BaseResponse response = service.removeTask(request);
        return response.convert();
    }

    @RequestMapping(
            value = "/api/updateTickTask",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> updateTickTask(@RequestBody UpdateTickTaskRequest request) {
        Map<String, Object> checkSessionResponse = sessionService.checkSessionId(request.getSessionId(), request.getTelephone());
        if ((Integer)checkSessionResponse.get(Constant.retCode) != 0) {
            return checkSessionResponse;
        }
        BaseResponse response = service.updateTask(request);
        return response.convert();
    }

    @RequestMapping(
            value = "/api/addTickTask",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> addTickTask(@RequestBody AddTickTaskRequest request) {
        Map<String, Object> checkSessionResponse = sessionService.checkSessionId(request.getSessionId(), request.getTelephone());
        if ((Integer)checkSessionResponse.get(Constant.retCode) != 0) {
            return checkSessionResponse;
        }
        BaseResponse response = service.addTask(request);
        return response.convert();
    }

    @RequestMapping(
            value = "/api/updateTickRecord",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> updateTickRecord(@RequestBody UpdateTickRecordRequest request) {
        Map<String, Object> checkSessionResponse = sessionService.checkSessionId(request.getSessionId(), request.getTelephone());
        if ((Integer)checkSessionResponse.get(Constant.retCode) != 0) {
            return checkSessionResponse;
        }
        BaseResponse response = service.updateTickRecord(request);
        return response.convert();
    }

}
