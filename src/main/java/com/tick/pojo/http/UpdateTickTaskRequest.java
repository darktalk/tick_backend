package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

public class UpdateTickTaskRequest {
    private Long id;
    private String telephone;
    private String sessionId;
    private String name;
    private String date;
    private String describe;
    private String period;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("telephone", telephone)
                .add("sessionId", sessionId)
                .add("id", id)
                .add("name", name)
                .add("date", date)
                .add("describe", describe)
                .add("period", period)
                .toString();
    }
}
