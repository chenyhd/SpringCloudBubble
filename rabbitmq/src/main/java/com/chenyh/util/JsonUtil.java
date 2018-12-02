package com.chenyh.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {


    private static ObjectMapper mapper = new ObjectMapper();

    public static String ObjectToJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }
    
    public static  <T> T jsonToObject(String josn, Class<T> valueType) throws IOException {
        return  mapper.readValue(josn,valueType);
    }
}
