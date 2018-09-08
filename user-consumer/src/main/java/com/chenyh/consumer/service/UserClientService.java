package com.chenyh.consumer.service;

import com.chenyh.consumer.service.fallback.UserServiceFallback;
import com.chenyh.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "user-provider",fallbackFactory= UserServiceFallback.class)
public interface UserClientService {

    @GetMapping("/user/list")
    List<User> list();

    @GetMapping("/user/{name}")
    User get(@PathVariable("name") String name);


}
