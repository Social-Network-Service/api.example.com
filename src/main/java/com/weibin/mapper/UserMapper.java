package com.weibin.mapper;

import com.weibin.entity.User;
import java.util.List;

public interface UserMapper {
    List<User> findAll();
    User findById(Integer id);
    int insert(User user);
    int update(User user);
    int delete(Integer id);
}
