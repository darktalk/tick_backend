package com.tick.mapper;

import com.tick.pojo.mybatis.Task;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskMapper {
    List<Task> getTasks(@Param("telephone") String telephone);
    Long addTickTask(@Param("telephone") String telephone, @Param("name") String name, @Param("describe") String describe,
                     @Param("period") String period, @Param("date") String date);
    void updateTickTask(@Param("name") String name, @Param("describe") String describe,
                        @Param("period") String period, @Param("date") String date, @Param("taskId") Long id);

    void deleteTickTask(@Param("taskId") Long taskId, @Param("telephone") String telephone);
}
