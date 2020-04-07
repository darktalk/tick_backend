package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

public class GetTickTaskRequest {

    private String telephone;
    private String sessionId;

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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("telephone", telephone)
                .add("sessionId", sessionId)
                .toString();
    }
}
