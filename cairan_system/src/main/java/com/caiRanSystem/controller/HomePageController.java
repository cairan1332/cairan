package com.caiRanSystem.controller;

import com.caiRanSystem.entity.sys.Catalogue;
import com.caiRanSystem.entity.sys.User;
import com.caiRanSystem.service.CatalogueService;
import com.caiRanSystem.util.CatalogueUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomePageController {
    @Value("${item.title}")
    String title;

    @Resource
    CatalogueService catalogueService;

    @GetMapping
    public String home(Model model, HttpSession session) {
        model.addAttribute("title", title);
        User user = (User) session.getAttribute("user");
        List<Catalogue> catalogueList = catalogueService.getCatalogueList(user);
        if (catalogueList != null) {
            model.addAttribute("catalogueTree", CatalogueUtil.createCatalogue(CatalogueUtil.getTree(catalogueList)));
        }
        model.addAttribute("user", user);
        return "home";
    }
}
