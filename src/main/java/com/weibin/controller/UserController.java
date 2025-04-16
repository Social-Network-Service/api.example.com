package com.weibin.controller;

import com.weibin.entity.User;
import com.weibin.service.UserService;
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
    public Result<User> getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return Result.success(user);
        }
        return Result.error(404, "用户不存在");
    }

    // 创建新用户
    @PostMapping
    public Result<User> createUser(@RequestBody User user) {
        int result = userService.insert(user);
        if (result > 0) {
            return Result.success(user, "创建成功");
        }
        return Result.error("创建失败");
    }

    // 更新用户信息
    @PutMapping("/{id}")
    public Result<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setUserId(id);
        int result = userService.update(user);
        if (result > 0) {
            return Result.success(user, "更新成功");
        }
        return Result.error("更新失败");
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable Integer id) {
        int result = userService.delete(id);
        if (result > 0) {
            return Result.success(null, "删除成功");
        }
        return Result.error(404, "用户不存在");
    }
}
