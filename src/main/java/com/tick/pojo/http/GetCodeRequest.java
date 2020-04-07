package com.tick.pojo.http;

import com.google.common.base.MoreObjects;

public class GetCodeRequest {
   private String telephone;

   public String getTelephone() {
      return telephone;
   }

   public void setTelephone(String telephone) {
      this.telephone = telephone;
   }

   @Override
   public String toString() {
      return MoreObjects.toStringHelper(this)
              .omitNullValues()
              .add("telephone", telephone).toString();
   }
}
