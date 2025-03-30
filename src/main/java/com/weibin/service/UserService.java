package com.weibin.service;

import com.weibin.entity.User;
import com.weibin.vo.PageResult;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    int insert(User user);
    int update(User user);
    int delete(Integer id);
    PageResult<User> findByPage(int pageNum, int pageSize);
}
