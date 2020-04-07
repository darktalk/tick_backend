package com.tick.pojo.mybatis;

import com.google.common.base.MoreObjects;

public class Task {
    private Long taskId;
    private String telephone;
    private String name;
    private String describe;
    private String period;
    private String date;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                .add("taskId", taskId)
                .add("telephone", telephone)
                .add("name", name)
                .add("describe", describe)
                .add("period", period)
                .add("date", date)
                .toString() + super.toString();
    }
}
