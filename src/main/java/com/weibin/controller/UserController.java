package com.weibin.controller;

import com.weibin.entity.User;
import com.weibin.entity.Video;
import com.weibin.service.UserService;
import com.weibin.vo.PageResult;
import com.weibin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    // 获取所有用户列表
    @GetMapping("/all")
    public Result<List<User>> getAllUsers() {
        List<User> videos = userService.getAllUsers();
        return Result.success(videos);
    }

    // 获取单个用户信息
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 创建新用户
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // 更新用户信息
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setUserId(id);
        return userService.updateUser(user);
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
