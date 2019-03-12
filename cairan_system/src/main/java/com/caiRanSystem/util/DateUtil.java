package com.caiRanSystem.util;

import java.text.SimpleDateFormat;


public class DateUtil {
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    static SimpleDateFormat dateFormat_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDate(long time) {
        return dateFormat.format(time);
    }

    public static String getDate() {
        return dateFormat_date.format(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getDate());
    }
}
