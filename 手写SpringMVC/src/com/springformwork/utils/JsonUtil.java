package com.springformwork.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * POJO转换为JSON
 */
public class JsonUtil {

    /**
     * 将POJO转化为JSON
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJSON(T obj) {
        String json = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


}
