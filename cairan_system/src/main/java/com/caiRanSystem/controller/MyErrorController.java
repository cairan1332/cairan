package com.caiRanSystem.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("error")
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        System.out.println("进入handleError");
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        System.out.println("statusCode==》"+statusCode);
        if(statusCode == 401){
            return "/401";
        }else if(statusCode == 404){
            return "/404";
        }else if(statusCode == 403){
            return "/403";
        }else{
            return "/500";
        }

    }
    @RequestMapping(value = "/error400Page")
    public String error400Page() {
        System.out.println("error400Page");
        return "page/error/404";
    }

    @RequestMapping(value = "/error401Page")
    public String error401Page() {
        return "page/error/401";
    }


    @RequestMapping(value = "/error404Page")
    public String error404Page(Model model) {
        model.addAttribute("code","6666666");
        model.addAttribute("msg","服务器降级中......");
        return "page/error/404";
    }
    @RequestMapping(value = "/error500Page")
    public String error500Page(Model model) {
        return "page/rror/500";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
