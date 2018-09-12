package com.springformwork.pojo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018-08-31
 * Time: 上午 11:22
 * explain: 返回视图JSP，视图中包含视图JSP路径和视图中所需的数据
 */
public class ModelAndView {

    //返回JSP路径
    private String path;

    //模型数据
    private Map<String,Object> attribute;

    public ModelAndView(String path) {
        this.path = path;
        attribute = new HashMap<>();
    }

    public ModelAndView setAttribute(String key, Object obj) {
        attribute.put(key,obj);
        return this;
    }

    public String getPath() {
        return path;
    }


    public Map<String, Object> getAttribute() {
        return attribute;
    }

}
