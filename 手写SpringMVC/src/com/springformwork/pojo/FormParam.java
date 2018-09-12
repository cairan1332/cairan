package com.springformwork.pojo;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 05:55
 * explain:表单参数
 */
public class FormParam {

    private String fieldName;
    private Object fieldValue;

    public FormParam(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
