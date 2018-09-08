package com.chenyh.consumer.controller;

import com.chenyh.entity.User;
import com.chenyh.consumer.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumer/user")
public class UserController {


    @Autowired
    private UserClientService userClientService;

    @GetMapping("{name}")
    public User get(@PathVariable("name")String name) throws Exception {
        User user = userClientService.get(name);
        return user;
    }

   @GetMapping("list")
    public List<User> list() throws Exception {
        return userClientService.list();
    }



}
