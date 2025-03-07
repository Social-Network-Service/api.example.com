package com.weibin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TestController {
    // @RequestMapping作用在方法上，不再区分get/post请求
    @RequestMapping("/test")
    @ResponseBody
    public String getTest() {
        return "Get Method Test! Current time is: ";
    }

    @PostMapping("/post_test")
    @ResponseBody
    public String postTest() {
        return "Post Method Test! Current time is: ";
    }
}
