package com.caiRanSystem.entity.sys;

import lombok.Data;


@Data
public class RequestLog {

    private int userId;//用户ID

    private String path;//请求名称

    private String note;//说明

    private long spendTime;//花费时间

    private boolean isSucceed;//是否成功

    private String requestTime;//请求时间

    private String returnTime;//返回时间

    private String className;//类名

    private String methodName;//方法名称

    public RequestLog(int userId, String path, String note, long spendTime, boolean isSucceed, String requestTime, String returnTime, String className, String methodName) {
        this.userId = userId;
        this.path = path;
        this.note = note;
        this.spendTime = spendTime;
        this.isSucceed = isSucceed;
        this.requestTime = requestTime;
        this.returnTime = returnTime;
        this.className = className;
        this.methodName = methodName;
    }
}
