package com.springformwork.pojo;

import com.springformwork.annotation.RequestMapping;
import com.springformwork.utils.ArrayUtil;
import com.springformwork.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 下午 03:43
 * explain: Controller request与处理请求handler映射关系
 */
public class ControllerMethod {
    //请求request与处理请求handler映射关系
    private static final Map<Request, HandlerMapping> RequestMap = new HashMap<>();

    static {
        Map<String, Object> controllerClasses = BeanClass.getBeanContainer();
        if (CollectionUtil.isNotEmpty( controllerClasses )) {
            for (Map.Entry entry : controllerClasses.entrySet()) {
                Class<?> controllerClass=entry.getValue().getClass();
                Method[] methods =controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty( methods )) {
                    Arrays.stream(methods)
                            .filter(method -> method.isAnnotationPresent(RequestMapping.class))
                            .forEach(method -> {
                                RequestMapping rm = method.getAnnotation(RequestMapping.class);
                                Request request = new Request(rm.method(), rm.path());
                                HandlerMapping handler = new HandlerMapping(controllerClass, method);
                                RequestMap.put(request, handler);
                            });
                }
            }
        }
    }

    /**
     * 获取handler
     *
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static HandlerMapping getHandlerMapping(String requestMethod, String requestPath) {
        System.out.println("RequestMap.size()=="+RequestMap.size());
        for(Map.Entry entry:RequestMap.entrySet()){
            System.out.println("request==>"+entry.getKey());
            System.out.println("HandlerMapping==>"+entry.getValue());
        }
        Request request = new Request(requestMethod, requestPath);
        return RequestMap.get(request);
    }

}
