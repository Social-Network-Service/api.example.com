package com.weibin.controller;

import com.weibin.entity.User;
import com.weibin.service.UserService;
import com.weibin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("/sys")
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
public class SystemController {

    @Autowired
    private UserService userService;

    // 登陆过期时间60秒
    private static int expirationTime = 60;

    @RequestMapping("/login")
    public Result login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        try {
            // 参数校验
            if (username == null || username.trim().isEmpty()) {
                throw new RuntimeException("用户名不能为空");
            }
            if (password == null || password.trim().isEmpty()) {
                throw new RuntimeException("密码不能为空");
            }

            // 调用service层进行登录验证
            User user = userService.login(username, password);

            // 创建session
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(expirationTime);
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("username", user.getUserName());

            // 生成sessionId并设置cookie
            String sessionId = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("sessionId", sessionId);
            cookie.setPath("/");
            cookie.setMaxAge(expirationTime);
            // 设置cookie的domain为localhost，这样可以在localhost:3000和localhost:8001之间共享
            // cookie.setDomain("localhost");
            response.addCookie(cookie);

            return Result.success("登录成功");
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    @RequestMapping("/registry")
    public Object register(String username, String password, String verifyCode, HttpServletRequest request) {
        return Result.success("用户创建成功");
    }
}
