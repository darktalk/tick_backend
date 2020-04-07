package com.tick.controller;

import com.google.common.base.Strings;
import com.tick.pojo.http.*;
import com.tick.service.LoginService;
import com.tick.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Login {
    private static final Logger LOG = LoggerFactory.getLogger(Login.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(
            value = "/api/getVerificationCode",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> getVerificationCode(@RequestBody GetCodeRequest request) {
        boolean result = loginService.generateVerifyCode(request);
        BaseResponse response = new BaseResponse();
        if (!result) {
            response.setMsg("can't generate verify code");
            response.setRetCode(-1);
        } else {
            response.setMsg("generate verify code success");
            response.setRetCode(0);
        }
        return response.convert();
    }

    @RequestMapping(
            value = "/api/verifyCode",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> verifyCode(@RequestBody VerifyCodeRequest request) {
        boolean result = loginService.checkVerifyCode(request);
        VerifyCodeResponse response = new VerifyCodeResponse();

        if (!result) {
            LOG.info("verify {} code:{} fail", request.getTelephone(), request.getVerifyCode());
            response.setMsg("can't generate verify code");
            response.setRetCode(-1);
        } else {
            String sessionId = loginService.registerSession(request.getTelephone());
            LOG.info("verify {} code:{} success, generate session id:{}", request.getTelephone(),
                    request.getVerifyCode(), sessionId);

            response.setMsg("generate verify code success");
            response.setRetCode(0);
            response.setTelephone(request.getTelephone());
            response.setSessionId(sessionId);
        }
        return response.convert();
    }


    @RequestMapping(
            value = "/api/verifySessionId",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8"
    )
    public Map<String, Object> verifySessionId(@RequestBody VerifySessionIdRequest request) {
        BaseResponse response = new BaseResponse();
        if (Strings.isNullOrEmpty(request.getTelephone()) || Strings.isNullOrEmpty(request.getSessionId())) {
            response.setMsg("invalid request parameter");
            response.setRetCode(-1);
            return response.convert();
        }

        return sessionService.checkSessionId(request.getSessionId(), request.getTelephone());
    }
}
