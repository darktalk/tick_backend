package com.tick.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;

import com.tencentcloudapi.sms.v20190711.SmsClient;

import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;


public class SendMsg {
    public static boolean send(String phone, String param1, String param2) {
        try{

            Credential cred = new Credential("AKIDdAnFbsfuiS47ENnq632vkT1SnAykJV9h", "aVJvU9oJWfdS7e5OWpcP0PeibIQOcrzw");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);

            System.out.println(params);
            SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);

            SendSmsResponse resp = client.SendSms(req);

            System.out.println(SendSmsRequest.toJsonString(resp));
            return true;
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return false;
        }

    }

}
