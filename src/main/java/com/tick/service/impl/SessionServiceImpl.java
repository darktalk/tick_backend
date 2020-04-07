package com.tick.service.impl;

import com.google.common.base.Strings;
import com.tick.pojo.http.BaseResponse;
import com.tick.service.SessionService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Component
public class SessionServiceImpl implements SessionService {
    ConcurrentHashMap<String, String> sessionCache = new ConcurrentHashMap<>();
    public final static Integer Number = 10;

    @Override
    public String generateSessionId(String telephone) {
        if (Strings.isNullOrEmpty(telephone)) {
            return "";
        }
        String sessionId = RandomStringUtils.randomAlphabetic(Number);
        while (sessionCache.containsKey(sessionId)) {
            sessionId = RandomStringUtils.randomAlphabetic(Number);
        }

        sessionCache.put(sessionId, telephone);
        return sessionId;
    }

    @Override
    public Map<String, Object> checkSessionId(String sessionId, String telephone) {
        BaseResponse response = new BaseResponse();
        if (Strings.isNullOrEmpty(telephone) || Strings.isNullOrEmpty(sessionId)) {
            response.setMsg("invalid session id");
            response.setRetCode(-1);
            return response.convert();
        }
        if (sessionCache.containsKey(sessionId) && sessionCache.get(sessionId).equals(telephone)) {
            response.setMsg("check session success");
            response.setRetCode(0);
            return response.convert();
        }

        response.setMsg("check session fail");
        response.setRetCode(-2);
        return response.convert();

    }
}
