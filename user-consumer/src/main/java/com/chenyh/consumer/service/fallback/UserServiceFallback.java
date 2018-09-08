package com.chenyh.consumer.service.fallback;

import com.chenyh.consumer.service.UserClientService;
import com.chenyh.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceFallback implements FallbackFactory<UserClientService>{

    @Autowired
    private DiscoveryClient client;

    @Override
    public UserClientService create(Throwable throwable) {
        return new UserClientService() {
            @Override
            public List<User> list() {
                return null;
            }

            @Override
            public User get(String name) {

                 return new User().setName(client.description()).setAge("503").setDbSource("No Data");
            }
        };
    }
}
