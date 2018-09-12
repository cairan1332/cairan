package com.springformwork.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 05:45
 * explain: 请求方法注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    enum RequetMethod {
        GET,
        POST,
        PUT,
        DELETE
    }
    //请求类型路径
    String path();
    //请求方法
    String method();
}
