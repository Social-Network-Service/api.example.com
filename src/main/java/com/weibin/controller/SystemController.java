package com.weibin.controller;

import com.weibin.vo.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sys")
@CrossOrigin(origins = {"http://localhost:3000", "https://localhost:3000"}, allowCredentials = "true")
public class SystemController {

    // 登陆过期时间60秒
    private static int expirationTime = 60;

    @RequestMapping("/login")
    public Object login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        return Result.success("用户登录成功");
    }

    @RequestMapping("/registry")
    public Object register(String username, String password, String verifyCode, HttpServletRequest request) {
        return Result.success("用户创建成功");
    }
}
