package com.chenyh.provier.service;

import com.chenyh.entity.User;

import java.util.List;


public interface UserService {


    List<User> getALl();

    User getOne(String name);



}
