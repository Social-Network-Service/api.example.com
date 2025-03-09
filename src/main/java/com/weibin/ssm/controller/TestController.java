package com.weibin.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/api")
public class TestController {
    // @RequestMapping作用在方法上，不再区分get/post请求
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "Test Request! Current time is: " + LocalDateTime.now();
    }

    @GetMapping("/get_test")
    @ResponseBody
    public String getTest() {
        return "Test Get Request! Current time is: " + LocalDateTime.now();
    }

    @PostMapping("/post_test")
    @ResponseBody
    public String postTest() {
        return "Test Post Request! Current time is: " + LocalDateTime.now();
    }
}
