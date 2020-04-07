package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetTickTaskResponseUnit implements Response {
    private String name;
    private String date;
    private String describe;
    private String period;
    private boolean isTickedToday;
    private List<String> tickedDate;
    private Long taskId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public boolean isTickedToday() {
        return isTickedToday;
    }

    public void setTickedToday(boolean tickedToday) {
        isTickedToday = tickedToday;
    }

    public List<String> getTickedDate() {
        return tickedDate;
    }

    public void setTickedDate(List<String> tickedDate) {
        this.tickedDate = tickedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("taskId", taskId)
                .add("name", name)
                .add("date", date)
                .add("describe", describe)
                .add("period", period)
                .add("isTickedToday", isTickedToday)
                .add("tickedDate", tickedDate)
                .toString() + super.toString();
    }

    @Override
    public Map<String, Object> convert() {
        Map<String, Object> response = new HashMap<>();
        response.put("name", name);
        response.put("date", date);
        response.put("describe", describe);
        response.put("period", period);
        response.put("isTickedToday", isTickedToday);
        response.put("tickedDate", tickedDate);
        response.put("taskId", taskId);
        return response;
    }
}
