package com.springformwork.utils;

/**
 * 字符串工具
 */
public class StringUtil {

    /**
     * 字符串分隔符
     */
    public static final String separator = String.valueOf( (char) 29 );

    /**
     * 判断字符串是否为空
     *
     * @param str 待判断字符串
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串是否非空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty( str );
    }

}
