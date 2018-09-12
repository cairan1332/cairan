package com.springformwork.utils;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 下午 04:04
 * explain:
 */
public class ArrayUtil {
    public static boolean isNotEmpty(Object[] fieldValues) {
        return !isEmpty( fieldValues );
    }

    public static boolean isEmpty(Object[] fieldValues) {
        if (fieldValues == null || (fieldValues != null && fieldValues.length == 0)) {
            return true;
        }
        return false;
    }
}
