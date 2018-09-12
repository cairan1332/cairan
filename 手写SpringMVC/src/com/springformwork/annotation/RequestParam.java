package com.springformwork.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018-08-31
 * Time: 上午 11:45
 * explain:请求参数
 */
@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestParam {
    String value() default "";
}

