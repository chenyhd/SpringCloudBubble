package com.chenyh.provider.mapper;

import com.chenyh.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
//@Rollback
public class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test1() {
        List<User> userList = new ArrayList<>();

        User user;
        for (int i = 0; i < 1000; i++) {
            user = new User()
                    .setAge("10")
                    .setDbSource("20")
                    .setName("name" + i);
            userList.add(user);
        }

        int rows = userMapper.insertMany(userList);

        System.out.println("插入影响行数"+rows);

    }


}