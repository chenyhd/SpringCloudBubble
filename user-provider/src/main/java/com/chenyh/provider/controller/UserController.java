package com.chenyh.provider.controller;

import com.chenyh.annotation.Intranet;
import com.chenyh.entity.User;
import com.chenyh.exception.IntranetException;
import com.chenyh.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
	private DiscoveryClient client;


    @GetMapping("{name}")
    @Intranet
    public User get(@PathVariable("name") String name) throws Exception {
        User user = userService.getOne(name);
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("---------------------");
        if(user ==null)
            throw new Exception();
        return  user;
    }


//    @Intranet
    @GetMapping("list")
    public List<User> list() throws IntranetException {
        System.out.println("11");
//        if(true){
//            throw new IntranetException("Controller Exception 内网");
//        }
        return userService.getALl();
    }

}
