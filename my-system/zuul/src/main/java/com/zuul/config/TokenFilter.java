package com.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/3/8
 * 类说明：
 * 版本号： 1.0
 */
@Component
@Log4j2
public class TokenFilter extends ZuulFilter {

    //    返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
    @Override
    public String filterType() {
        //    pre：路由之前
        //    routing：路由之时
        //    post： 路由之后
        //    error：发送错误调用
        return "pre";
    }

    //    过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //    可以写逻辑判断，是否要过滤，本文true,永远过滤。
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String path=request.getServletPath();
        log.info("path ==> {}",path);
        return true;
    }

    //    过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;

    }
}
