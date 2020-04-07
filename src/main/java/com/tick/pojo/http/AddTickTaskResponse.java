package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

import java.util.Map;

public class AddTickTaskResponse extends BaseResponse {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("id", id)
                .toString() + super.toString();
    }

    @Override
    public Map<String, Object> convert() {
        Map<String, Object> response = super.convert();
        response.put("id", id);
        return response;
    }
}
