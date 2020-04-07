package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

public class VerifyCodeRequest {
   private String telephone;
   private String verifyCode;

   public String getTelephone() {
      return telephone;
   }

   public void setTelephone(String telephone) {
      this.telephone = telephone;
   }

   public String getVerifyCode() {
      return verifyCode;
   }

   public void setVerifyCode(String verifyCode) {
      this.verifyCode = verifyCode;
   }

   @Override
   public String toString() {
      return MoreObjects.toStringHelper(this)
              .omitNullValues()
              .add("telephone", telephone)
              .add("verifyCode", verifyCode)
              .toString();
   }
}
