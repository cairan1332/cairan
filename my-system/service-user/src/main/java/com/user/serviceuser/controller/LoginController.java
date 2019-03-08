package com.user.serviceuser.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/3/7
 * 类说明：
 * 版本号： 1.0
 */
@RestController
public class LoginController {
    @Value("${server.port}")
    String port;

    @RequestMapping("/login")
    public Object login(){
        return "登录成功 port:"+port;
    }
}
