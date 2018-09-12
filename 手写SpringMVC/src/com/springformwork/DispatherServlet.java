package com.springformwork;

import com.springformwork.pojo.BeanClass;
import com.springformwork.pojo.ControllerMethod;
import com.springformwork.pojo.Data;
import com.springformwork.pojo.HandlerMapping;
import com.springformwork.utils.BeanFactory;
import com.springformwork.utils.ParamUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: 蔡燃
 * Date: 2018/08/28
 * Time: 下午 05:44
 * explain:
 */

public class DispatherServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        Loader.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法
        String requestMethod = req.getMethod().toLowerCase( Locale.ENGLISH );
        //请求路径url
        String url = req.getRequestURI();
        url = url.replaceAll( "/+", "/" );
        String contextPath = req.getContextPath();
        String requestPath = url.replace( contextPath, "" );
        HandlerMapping handlerMapping = ControllerMethod.getHandlerMapping( requestMethod, requestPath );
        if (handlerMapping != null) {
            Class<?> controllerClass = handlerMapping.getClasses();
            Object controllerBean = BeanClass.getBean( controllerClass.getName() );
            Method method = handlerMapping.getMethod();//处理请求的方法
            Object result;//请求返回对象
            if (method.getParameters().length == 0) {//无参数
                result = BeanFactory.invokeMethod( controllerBean, method );
            } else {//有参数
                result = BeanFactory.invokeMethod( controllerBean, method, ParamUtil.getParam( method, req ,resp) );
            }
            handleDataResult( (Data) result, resp );
        } else {
            resp.getWriter().write( "404 Not Found" );
        }
    }

    //返回JSON数据
    private static void handleDataResult(Data data, HttpServletResponse resp)
            throws IOException {
        Object model = data.getData();
        if (model != null) {
            resp.setContentType( "application/json" );
            resp.setCharacterEncoding( "UTF-8" );
            PrintWriter writer = resp.getWriter();
//            String json = JsonUtil.toJSON( model );
            String str = model.toString();
            writer.write( str );
            writer.close();
        }
    }

}

