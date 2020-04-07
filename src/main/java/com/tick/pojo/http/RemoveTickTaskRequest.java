package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

public class RemoveTickTaskRequest {
    private String telephone;
    private String sessionId;
    private Long taskId;

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


    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("telephone", telephone)
                .add("sessionId", sessionId)
                .add("taskId", taskId)
                .toString();
    }
}
