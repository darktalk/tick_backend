package com.tick.service;

import com.tick.pojo.http.*;

public interface TickTaskService {
   GetTickTaskResponse requestTasks(GetTickTaskRequest request);
   BaseResponse updateTask(UpdateTickTaskRequest request);
   BaseResponse removeTask(RemoveTickTaskRequest request);
   AddTickTaskResponse addTask(AddTickTaskRequest request);
   BaseResponse updateTickRecord(UpdateTickRecordRequest request);
}
