package com.tick.pojo.mybatis;

import com.google.common.base.MoreObjects;

public class TickRecord {
    private Long recordId;
    private String date;
    private Long taskId;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
                .add("recordId", recordId)
                .add("date", date)
                .add("taskId", taskId)
                .toString() + super.toString();
    }
}
