package com.caiRanSystem.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class IndexController {
    @Value("${item.title}")
    String title;

    @GetMapping("/")
    public String index(Model model) {
        System.out.println("进入index()");
        model.addAttribute("title", title);
        System.out.println(title);
        return "index";
    }
}
