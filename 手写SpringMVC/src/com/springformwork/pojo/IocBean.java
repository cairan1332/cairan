package com.springformwork.pojo;

import com.springformwork.annotation.Autowired;
import com.springformwork.utils.ArrayUtil;
import com.springformwork.utils.BeanFactory;
import com.springformwork.utils.CollectionUtil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018-08-31
 * Time: 上午 10:26
 * explain:依赖注入，注入bean
 */
public class IocBean {

    static {
        System.out.println("依赖注入,注入bean");
        if (CollectionUtil.isNotEmpty(BeanClass.getBeanContainer())) {
            initIOC();
        }
    }

    private static void initIOC() {
        for (Map.Entry<String, Object> beanEntry : BeanClass.getBeanContainer().entrySet()) {
            String className = beanEntry.getKey();
            Object beanInstance = beanEntry.getValue();
            Class<?> beanClass = null;
            System.out.println("className===>"+className);

            try {
                beanClass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Controller类中定义的属性
            assert beanClass != null; // beanClass不能为空，加个断言
            Field[] beanFields = beanClass.getDeclaredFields();
            if (ArrayUtil.isNotEmpty(beanFields)) {

                Arrays.stream(beanFields)
                        .filter(beanField -> beanField.isAnnotationPresent(Autowired.class))
                        .forEach(beanField -> {
                            Autowired annotation = beanField.getAnnotation( Autowired.class );
                            String beanName = annotation.value().trim();
                            if ("".equals( beanName )) {
                                //默认接口注入
                                beanName = beanField.getType().getName();
                            }
                            Object beanFieldInstance =BeanClass.getBean( beanName );
                            System.out.println("beanFieldClass===>"+beanFieldInstance);
                            //成员变量的类
                            Class<?> beanFieldClass = beanField.getType();
                            System.out.println("beanFieldClass===>"+beanFieldClass);
                            if (beanFieldInstance != null) {
                                //依赖注入
                                BeanFactory.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        });

            }
        }
    }
}
