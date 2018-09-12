package com.springformwork.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 06:07
 * explain:类工具类
 */
public class ClassUtil {


    /**
     * 获取类加载器
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     *
     * @param className
     * @param isInitialized 是否执行类的静态代码块
     * @return
     */
    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className, isInitialized, getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return clazz;
    }

    /**
     * 获取指定包下所有类
     *
     * @param packageName
     * @return
     */
    public static ArrayList<Class<?>> getClasses(String packageName) {
        ArrayList<Class<?>> arrayList = new ArrayList<>();
        URL url = getClassLoader().getResource( "/" + packageName.replaceAll( "\\.", "/" ) );
        File dir = new File( url.getFile() );

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                arrayList.addAll( getClasses( packageName + "." + file.getName() ) );
            } else {
                String className = packageName + "." + file.getName().replace( ".class", "" );
                arrayList.add( loadClass( className ,true) );
            }
        }
        return arrayList;
    }


    /**
     * 首字母小写
     *
     * @param str
     * @return
     */
    public static String lowerFirst(Class<?> beanClass) {

        return lowerFirst( beanClass.getName() );
    }

    public static String lowerFirst(String  str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf( chars );
    }
}
