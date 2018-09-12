package com.springformwork.pojo;

import com.springformwork.utils.CollectionUtil;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 05:59
 * explain:
 */
public class Param {
    private List<FormParam> formParams;

    public Param(List<FormParam> formParams) {
        this.formParams = formParams;
    }

    /**
     * 判断参数是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return CollectionUtil.isEmpty(formParams);
    }
}
