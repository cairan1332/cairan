package com.springformwork.utils;

import com.springformwork.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018-09-01
 * Time: 上午 10:52
 * explain: 设置参数
 */
public class ParamUtil {

    public static Object[] getParam(Method method, HttpServletRequest req, HttpServletResponse resp) {
        method.setAccessible( true );
        Parameter[] parameters = method.getParameters();
        Object[] objects = new Object[parameters.length];
        for (int j = 0; j < parameters.length; j++) {
            Parameter parameter = parameters[j];
            if (parameter.isAnnotationPresent( RequestParam.class )) {
                objects[j] = setParameterValue( parameter, req );
            } else if (parameter.getType().equals( HttpServletRequest.class )) {
                objects[j] = req;
            } else if (parameter.getType().equals( HttpServletResponse.class )) {
                objects[j] = resp;
            } else if (parameter.getType().equals( String.class )) {
                objects[j] = req.getParameter( parameter.getName() );
            }
        }
        return objects;
    }

    private static Object setParameterValue(Parameter parameter, HttpServletRequest req) {
        RequestParam requestParam = parameter.getAnnotation( RequestParam.class );
        String paramName = requestParam.value();
        if (paramName.equals( "" )) {
            paramName = parameter.getName();
        }
        String classType = parameter.getType().getName();
        String reqParameter = req.getParameter( paramName );
        if (classType.equals( "int" )) {
            return Integer.parseInt( reqParameter );
        } else if (classType.equals( "java.lang.String" )) {
            return reqParameter;
        }
        return null;
    }
}
