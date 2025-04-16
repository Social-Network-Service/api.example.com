package com.weibin.mapper;

import com.weibin.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectAll();

    User selectById(Long id);

    int insert(User user);

    int update(User user);

    int delete(Integer id);
}