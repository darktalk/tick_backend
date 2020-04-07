package com.tick.service;

import com.tick.pojo.http.GetCodeRequest;
import com.tick.pojo.http.VerifyCodeRequest;

public interface LoginService {
    boolean generateVerifyCode(GetCodeRequest request);
    boolean checkVerifyCode(VerifyCodeRequest request);
    String registerSession(String telephone);
}
