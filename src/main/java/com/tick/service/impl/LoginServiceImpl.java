package com.tick.service.impl;

import com.google.common.base.Strings;
import com.tick.pojo.http.GetCodeRequest;
import com.tick.pojo.http.VerifyCodeRequest;
import com.tick.service.LoginService;
import com.tick.service.SessionService;
import com.tick.util.SendMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LoginServiceImpl implements LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);
    ConcurrentHashMap<String, String> verifyCodeCache = new ConcurrentHashMap<>();

    @Autowired
    SessionService sessionService;

    @Override
    public boolean generateVerifyCode(GetCodeRequest request) {
        if (Strings.isNullOrEmpty(request.getTelephone())) {
            return false;
        }
        LOG.info("get generate verify code telephone:{}", request.getTelephone());

        // todo 需要验证验证码的时效性，还有禁止频繁发送等等
        String code = String.format("%06d", new Random().nextInt(1000000));
        if (!SendMsg.send(request.getTelephone(), "aaa", code)) {
            return false;
        }
        LOG.info("generate verify code telephone:{}, code:{}", request.getTelephone(), code);
        verifyCodeCache.put(request.getTelephone(), code);
        return true;
    }

    @Override
    public boolean checkVerifyCode(VerifyCodeRequest request) {
        if (Strings.isNullOrEmpty(request.getTelephone()) || Strings.isNullOrEmpty(request.getVerifyCode())) {
            LOG.error("verify code error, empty telephone or verify code");
            return false;
        }
        String telephone = request.getTelephone();
        if (verifyCodeCache.containsKey(telephone)) {
            return verifyCodeCache.get(telephone).equals(request.getVerifyCode());
        }
        return false;
    }

    @Override
    public String registerSession(String telephone) {
        return sessionService.generateSessionId(telephone);
    }
}
