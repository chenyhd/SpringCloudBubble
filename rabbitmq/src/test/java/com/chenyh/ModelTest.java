package com.chenyh;

import com.chenyh.Model.User;
import com.chenyh.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.io.IOException;

public class ModelTest {


    @Test
    public void test1() throws JsonProcessingException {
        User user = new User()
                .setUserName("chenyh非常6+1")
                .setAge(10)
                .setMethod("post")
                .setAddress("{\"country\":\"China\",\"province/station\":\"上海\",\"street\":\"sijing\"}");

        System.out.println(JsonUtil.ObjectToJson(user));


    }


    //{"userName":"chenyh非常6+1","age":10,"method":"post","address":"{\"country\":\"China\",\"province/station\":\"上海\",\"street\":\"sijing\"}"}

    @Test
    public void test2() throws IOException {
        //language=JSON
        String json = "{\"userName\":\"chenyh非常6+1\",\"age\":10,\"method\":\"post\",\"address\":\"{\\\"country\\\":\\\"China\\\",\\\"province/station\\\":\\\"上海\\\",\\\"street\\\":\\\"sijing\\\"}\",\"hobby\":\"none\"}";

        User user = JsonUtil.jsonToObject(json, User.class);

        System.out.println(user.getAddress());

    }


}
