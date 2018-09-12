package com.springformwork.pojo;

import com.springformwork.annotation.Controller;
import com.springformwork.annotation.Service;
import com.springformwork.utils.BeanFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 06:00
 * explain:IOC容器
 */
public class BeanClass {

    /**
     * 存放Bean类和Bean实例的映射关系
     */
    private static final Map<String, Object> BEAN_CALSS = new HashMap<>();

    static {
        System.out.println( "IOC容器" );
        ArrayList<Class<?>> beanClasses = Classes.getBeanClasses();
        beanClasses
                .stream()
                .filter( beanClass -> beanClass.isAnnotationPresent( Controller.class ) || beanClass.isAnnotationPresent( Service.class ) )
                .forEach( beanClass -> setBeanClass( beanClass ) );
    }

    private static void setBeanClass(Class<?> beanClass) {
        if (beanClass.isAnnotationPresent( Controller.class )) {
            BEAN_CALSS.put(beanClass.getName(), BeanFactory.newInstance( beanClass ) );
        } else if (beanClass.isAnnotationPresent( Service.class )) {
            //如果加@Service，就认为是一个Service可以初始化
            Service service = beanClass.getAnnotation( Service.class );
            //1.如果自己起名字，优先使用起的名字作为beanName
            String beanName = service.value();
            if ("".equals( beanName )) {
                //2.如果没有名字，类名首字母小写作为beanName
                beanName =beanClass.getName();
            }
            BEAN_CALSS.put( beanName, BeanFactory.newInstance( beanClass ) );
            //3.注入对象是接口，采用其实现接口的全称作为beanName
            Class<?>[] interfaces = beanClass.getInterfaces();
            Arrays.stream( interfaces ).forEach( i -> BEAN_CALSS.put(i.getName(), BeanFactory.newInstance( beanClass ) ) );
        }
    }

    /**
     * 获取Bean映射
     *
     * @return
     */
    public static Map<String, Object> getBeanContainer() {
        for(String s:BEAN_CALSS.keySet()){
            System.out.println("classNAme==>"+s);
        }
        return BEAN_CALSS;
    }

    /**
     * 获取Bean实例
     */
    public static <T> T getBean(String className) {
        if (!BEAN_CALSS.containsKey( className )) {
            throw new RuntimeException( "不能通过【" + className + "】获取实例" );
        }
        return (T) BEAN_CALSS.get( className );
    }

    /**
     * 设置Bean实例
     */
    public static void setBean(String className, Object obj) {
        BEAN_CALSS.put( className, obj );
    }
}
