package com.springformwork.pojo;

import com.springformwork.annotation.Controller;
import com.springformwork.annotation.Service;
import com.springformwork.utils.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 上午 10:03
 * explain:扫描包名下所有的类
 */
public class Classes {
    //基础包名下所有的类
    private static ArrayList<java.lang.Class<?>> classes;

    static {
        System.out.println("扫描包名下所有的类");
        String basePackage = Application.getProperty( "scanPackage" );
        classes = ClassUtil.getClasses(basePackage);
    }

    /**
     * 获取基础包名下所有的类
     *
     * @return
     */
    public static ArrayList<Class<?>> getClasses() {
        return classes;
    }

    /**
     * 获取所有Service类
     *
     * @return
     */
    public static ArrayList<Class<?>> getServiceClasses() {
        return classes.stream()
                .filter(c -> c.isAnnotationPresent(Service.class))
                .collect( Collectors.toCollection(ArrayList::new));
    }

    /**
     * 获取所有Controller类
     *
     * @return
     */
    public static ArrayList<Class<?>> getControllerClasses() {
        return classes.stream()
                .filter(c -> c.isAnnotationPresent(Controller.class))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * 框架Bean容器主要管理Service,Controller类
     *
     * @return
     */
    public static ArrayList<Class<?>> getBeanClasses() {
        ArrayList<Class<?>> bc = new ArrayList<>();
        bc.addAll(getServiceClasses());
        bc.addAll(getControllerClasses());
        return bc;
    }

    /**
     * 获取父类或者接口的所有子类或者实现类
     * @param superClass
     * @return
     */
    public static ArrayList<Class<?>> getClassListBySuper(Class<?> superClass) {
        return classes.stream()
                .filter(cls -> superClass.isAssignableFrom(cls) && !superClass.equals(cls))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * 获取有某一个注解的全部类
     * @param annotationClass
     * @return
     */
    public static ArrayList<Class<?>> getClassListByAnnotation(Class<? extends Annotation> annotationClass) {
        return classes.stream()
                .filter(cls -> cls.isAnnotationPresent(annotationClass))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
