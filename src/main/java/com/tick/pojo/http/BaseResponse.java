package com.tick.pojo.http;


import com.google.common.base.MoreObjects;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse implements Response {
    private int retCode;
    private String msg;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("retCode", retCode)
                .add("msg", msg).toString();
    }

    @Override
    public Map<String, Object> convert() {
        Map<String, Object> response = new HashMap<>();
        response.put("retCode", retCode);
        response.put("msg", msg);
        return response;
    }
}
