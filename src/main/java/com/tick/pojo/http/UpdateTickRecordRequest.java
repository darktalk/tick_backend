package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

public class UpdateTickRecordRequest {
    private String telephone;
    private String sessionId;
    private Long taskId;
    private String date;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("telephone", telephone)
                .add("sessionId", sessionId)
                .add("taskId", taskId)
                .add("date", date)
                .add("type", type)
                .toString();
    }
}
