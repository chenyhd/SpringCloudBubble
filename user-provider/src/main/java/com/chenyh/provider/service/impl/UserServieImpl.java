package com.chenyh.provider.service.impl;

import com.chenyh.entity.User;
import com.chenyh.provider.mapper.UserMapper;
import com.chenyh.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServieImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getALl() {
        return userMapper.getAll();
    }

    @Override
    public User getOne(String name) {
        return userMapper.getOne(name);
    }
}
