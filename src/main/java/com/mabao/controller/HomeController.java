package com.mabao.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class HomeController {

    public HomeController() {
    }

    /**
     * jsp页面跳转控制器
     * @param jspPage  页面名
     * @urn jspPage.jsp  页面名对应的jsp页面
     */
    @RequestMapping(value = "/jsp/{jspPage}", method = GET)
    public String defaultPage(@PathVariable("jspPage") String jspPage){
        return jspPage;
    }

    /**
     * 首页
     *（查询商品类别，轮播图片，新品列表）
     * @return              index首页
     */
    @RequestMapping(method = GET)
    public String home() {
        return "index";
    }

}
