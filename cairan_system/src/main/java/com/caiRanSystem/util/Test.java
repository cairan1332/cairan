package com.caiRanSystem.util;

import com.caiRanSystem.util.pullText.PullText;
import com.caiRanSystem.entity.book.RegexReplace;
import com.caiRanSystem.util.pullText.UrlText;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("程序启动，开始获取数据。。。");
        UrlText urlText = new UrlText();
        urlText.setBeginStr("正文卷");
        urlText.setEndStr("<div id=\"footer\" name=\"footer\">");
        urlText.setUrlRegex("<a[^>]+?href =[\"']?([^\"']+)[\"']?[^>]*>([^<]+)</a>");
        urlText.setContentRegex("<div id=\"content\" class=\"showtxt\">([^\"]+)[^>]*</div>");
        List<RegexReplace> list = new ArrayList<>();
        list.add(new RegexReplace("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;", "\t"));
        list.add(new RegexReplace("<br /><br />", "\r\n"));
        urlText.setReplaceList(list);
        urlText.setIp("http://www.abcxs.com");
        urlText.setPath("/book/11/");
        urlText.setFilePath("D:/工作区/拉取");
        urlText.setFileName("我的1979.txt");
        PullText.getData(urlText);
        System.out.println("程序结束。");
    }
}
