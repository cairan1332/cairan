package com.caiRanSystem.controller;

import com.caiRanSystem.config.aop.AnalysisActuator;
import com.caiRanSystem.entity.sys.LoginLog;
import com.caiRanSystem.entity.sys.User;
import com.caiRanSystem.service.LoginService;
import com.caiRanSystem.util.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping
@Controller
public class LoginController {
    @Value("${item.title}")
    String title;

    @Resource
    LoginService loginService;

    @AnalysisActuator(note = "用户登录")
    @PostMapping("login")
    public String login(@RequestParam String userName, @RequestParam String password
            , Model model, HttpServletRequest request, HttpSession session) {
        User user = loginService.login(userName, password);
        model.addAttribute("title", title);
        if (user == null) {
            model.addAttribute("message", "用户名或密码错误");
            return "index";
        }
        user.setToken(generateToken(user));
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        LoginLog loginLog = new LoginLog(request, user);
        loginService.addLoginLog(loginLog);
        return "redirect:home";
    }

//    @AnalysisActuator(note = "注销登录")
    @GetMapping("logout")
    public String logout(HttpSession session)  {
        User user = (User) session.getAttribute("user");
        LoginLog loginLog = new LoginLog(user);
        System.out.println(user);
        loginService.logoutLog(loginLog);
        session.invalidate();
        return "redirect:";
    }

    private String generateToken(User user) {
        return MD5Util.EncoderByMd5(user.getUserName() + user.getUserId() + System.currentTimeMillis());
    }
}
