package com.feign.web;

import com.feign.clients.SchedualServiceUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创建人： 蔡燃
 * 邮  箱： 792150181@qq.com
 * 日  期： 2019/3/7
 * 类说明：
 * 版本号： 1.0
 */
@RestController
public class UserController {

    @Resource
    SchedualServiceUser schedualServiceUser;

    @GetMapping(value = "/login")
    public String login() {
        return schedualServiceUser.login();
    }
}
