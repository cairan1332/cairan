package com.springformwork.pojo;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 05:57
 * explain:封装RequestMapping信息
 */
public class HandlerMapping {
    private Class<?> classes;

    private Method method;

    public HandlerMapping(Class<?> classes, Method method) {
        this.classes = classes;
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public Class<?> getClasses() {
        return classes;
    }


    public void setMethod(Method method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "HandlerMapping{" +
                "classes=" + classes +
                ", method=" + method +
                '}';
    }
}
