package com.chenyh;

import com.chenyh.util.IPUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IPTest {


    @Test
    public void isinnerIP() throws IOException {
        ObjectMapper objMapper = new ObjectMapper();

        File f = new File("src/test/java/com/chenyh/test/data/jsonData.json");
        System.out.println(f.getAbsolutePath());

        Map<String,Object> map = objMapper.readValue(f, Map.class);
        List list = (List) map.get("ip");
        System.out.println(list.toString());
        for (Object ip:list){
            System.out.println(ip.toString()+"==>" +IPUtil.internalIp(ip.toString() ));
        }
    }
}
