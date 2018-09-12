package com.springformwork;

//import com.springformwork.pojo.Application;

import com.springformwork.pojo.*;
import com.springformwork.utils.ClassUtil;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 上午 09:51
 * explain:初始化框架
 */
public class Loader {

    public static void init() {
        System.out.println("初始化框架");
        Class<?>[] cs = {
                Application.class,//1.加载配置文件application.properties
                Classes.class, //2.扫描到相关的类
                BeanClass.class,//3.初始化所以相关的类，添加到IOC容器中（自己实现一个IOC类）
                IocBean.class,//4.依赖注入,
                ControllerMethod.class//5.url与方法对应
               };
        Arrays.stream( cs )
                .forEach( c -> ClassUtil.loadClass( c.getName(), true ) );

    }
}
