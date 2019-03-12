package com.caiRanSystem.config.aop;

import com.caiRanSystem.entity.sys.RequestLog;
import com.caiRanSystem.entity.sys.User;
import com.caiRanSystem.service.RequestLogService;
import com.caiRanSystem.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 使用自定义注解来统计方法的执行时间
 */
@Aspect
@Component
@Log4j2
@Order(100)
public class AnalysisActuatorAspectAop {

    @Resource
    RequestLogService logService;

    @Pointcut("@annotation(analysisActuator)")
    public void serviceStatistics(AnalysisActuator analysisActuator) {
    }

    ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Before("serviceStatistics(analysisActuator)")
    public void doBefore(JoinPoint joinPoint, AnalysisActuator analysisActuator) {
        // 记录请求到达时间
        beginTime.set(System.currentTimeMillis());
        log.info("cy666 note:{}", analysisActuator.note());
    }

    @After("serviceStatistics(analysisActuator)")
    public void doAfter(JoinPoint joinPoint, AnalysisActuator analysisActuator) {
        log.info("cy666 statistic time:{}, note:{}", System.currentTimeMillis() - beginTime.get(), analysisActuator.note());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        long endTime = System.currentTimeMillis();
        long time = endTime - beginTime.get();
        boolean isSucceed = true;
        RequestLog record = new RequestLog(user.getUserId(), request.getServletPath(), analysisActuator.note(), time, isSucceed, DateUtil.getDate(beginTime.get()), DateUtil.getDate(endTime), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logService.addRequestRecord(record);

    }


}
