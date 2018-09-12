package com.springformwork.pojo;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/29
 * Time: 下午 03:45
 * explain:请求信息
 */
public class Request {

    //请求方法
    private String requestMethod;
    //请求路径
    private String requestPath;

    public Request(String requestMethod, String requestPath) {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public String getRequestPath() {
        return requestPath;
    }

    @Override
    public int hashCode() {
        Request request = (Request) this;
        return (requestMethod+requestPath).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Request) {
            Request request = (Request) obj;
            return (requestMethod.equals(request.requestMethod)&&requestPath.equals(request.requestPath ));
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestMethod='" + requestMethod + '\'' +
                ", requestPath='" + requestPath + '\'' +
                '}';
    }
}
