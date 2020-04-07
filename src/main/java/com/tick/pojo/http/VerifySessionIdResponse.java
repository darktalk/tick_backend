package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

import java.util.Map;

public class VerifySessionIdResponse extends BaseResponse implements Response {

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
                .add("sessionId"
                        , sessionId)
                .toString() + super.toString();
    }

    @Override
    public Map<String, Object> convert() {
        Map<String, Object> response = super.convert();
        response.put("telephone", telephone);
        response.put("sessionId", sessionId);
        return response;
    }
}
