package com.tick.util;

import com.google.common.base.Strings;

public class TDate {
   public static String format(String date) {
        if (Strings.isNullOrEmpty(date)) {
            return "";
        }
        String[] elems = date.split("T");
        if (elems.length < 1) {
            return "";
        }
        String newDate = elems[0];
        String[] elems2 = newDate.split("-");
        if (elems2.length != 3) {
            return "";
        }
        if (elems2[1].length() == 1) {
            elems2[1] = "0" + elems2[1];
        }
        if (elems2[2].length() == 1) {
            elems2[2] = "0" + elems2[2];
        }
        return elems2[0] + "-" + elems2[1] + "-" + elems2[2];

    }
}
