package com.caiRanSystem.config.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/3/12
 * 类说明：
 * 版本号： 1.0
 */
@Aspect
@Component
@Log4j2
@Order(1)
public class LoggerAop {

    @Pointcut("execution(public * com.caiRanSystem.controller.*.*(..))")
    public void loggerAop() {
    }

    @Before("loggerAop()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        Signature signature=joinPoint.getSignature();
        log.warn("进入 {} 的 {} 方法 " ,signature.getDeclaringTypeName(),signature.getName());
    }

    @AfterReturning(returning = "ret", pointcut = "loggerAop()")
    public void doAfterReturning(JoinPoint joinPoint,Object ret) throws Throwable {
        // 处理完请求，返回内容
        Signature signature=joinPoint.getSignature();
        log.debug("{} 的 {} 方法的返回数据 : {}" ,signature.getDeclaringTypeName(),signature.getName(), ret);
        // 接收到请求，记录请求内容


    }
}
