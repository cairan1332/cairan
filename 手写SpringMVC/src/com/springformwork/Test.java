package com.springformwork;

import dome.web.controller.TestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018-08-31
 * Time: 上午 11:50
 * explain:
 */
public class Test {
//    public static void main(String[] args) {
//        Method[] methods = TestController.class.getDeclaredMethods();
//        for (int i = 0; i < methods.length; i++) {
//            Method method = methods[i];
//            method.setAccessible( true );
//            Parameter[] parameters = method.getParameters();
//            for (int j = 0; j < parameters.length; j++) {
//                Parameter parameter = parameters[j];
//                if (parameter.isAnnotationPresent( RequestParam.class )) {
//                    RequestParam requestParam = parameter.getAnnotation( RequestParam.class );
//                    String paramName = requestParam.value();
//                    if (paramName.equals( "" )) {
//                        paramName = parameter.getName();
//                    }
//
//
////                    System.out.println( parameter.getType().getName());
//                    System.out.println(paramName);
//                }
//
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {
        for (Method m : TestController.class.getMethods()) {
            System.out.println("----------------------------------------");
            System.out.println("   method: " + m.getName());
            System.out.println("   return: " + m.getReturnType().getName());
            for (Parameter p : m.getParameters()) {
                System.out.println("parameter: " + p.getType().getName() + ", " + p.getName());
                System.out.println( p.getType()  );
                System.out.println( HttpServletRequest.class );
                System.out.println( p.getType().equals(HttpServletRequest.class) );
                System.out.println( p.getType().getName().equals(HttpServletRequest.class.getName()    ) );
            }
        }
    }
}
