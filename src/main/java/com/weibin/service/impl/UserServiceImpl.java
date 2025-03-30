package com.weibin.service.impl;

import com.weibin.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class UserServiceImpl {
    @Resource
    UserMapper userMapper;
}
