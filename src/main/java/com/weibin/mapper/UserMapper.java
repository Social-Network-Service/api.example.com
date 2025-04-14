package com.weibin.mapper;

import com.weibin.entity.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {
    List<User> selectAll();
    User selectById(Long id);
    void insert(User user);
    void updateById(User user);
    void deleteById(Long id);
}