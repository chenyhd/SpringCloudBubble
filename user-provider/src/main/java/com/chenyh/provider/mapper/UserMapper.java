package com.chenyh.provider.mapper;


import com.chenyh.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getAll();

    @Select("select * from user where name=#{name}")
    User getOne(String name);

    @Update("update user set age=#{age} where name=#{name}")
    void update();

    int insertMany(@Param("users") List<User> users);
}
