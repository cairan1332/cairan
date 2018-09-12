package com.springformwork.pojo;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 05:56
 * explain:返回数据
 */
public class Data<T> {

    //数据
    private T data;

    public Data(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
