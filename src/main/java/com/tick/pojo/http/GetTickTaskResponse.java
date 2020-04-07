package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

import java.util.List;
import java.util.Map;

public class GetTickTaskResponse extends BaseResponse {
    private List<Map<String, Object>> tasks;

    public List<Map<String, Object>> getTasks() {
        return tasks;
    }

    public void setTasks(List<Map<String, Object>> tasks) {
        this.tasks = tasks;
    }


    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("tasks", tasks)
                .toString() + super.toString();
    }

    @Override
    public Map<String, Object> convert() {
        Map<String, Object> response = super.convert();
        response.put("tasks", tasks);
        return response;
    }
}
