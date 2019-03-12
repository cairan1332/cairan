package com.caiRanSystem.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class MD5Util {

    /**
     * 利用MD5进行加密
     */
    public static String EncoderByMd5(String str) {
        //确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            return base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) {

        String str = "appl454weqweqasdaasdasasdaweqwqwqwee11e";
        String newString = MD5Util.EncoderByMd5(str);
        System.out.println(newString);

    }
}
