package com.weibin.service;

import com.weibin.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    int insert(User user);

    int update(User user);

    int delete(Integer id);
}