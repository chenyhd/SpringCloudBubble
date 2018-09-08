package com.chenyh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootTest(classes=RabbitApplication.class)
public class RabbitTest{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void hello() throws Exception {
        int i = 0;
        while (true) {
            Thread.sleep(2000);
            rabbitTemplate.convertAndSend("message","hello.chicken.fried","--message--" + ++i);
        }
    }

    @Test
    public void topic() throws Exception {
        int i = 0;
        while (true) {
            Thread.sleep(2000);
            rabbitTemplate.convertAndSend("topicExchange","hello.chicken.fried",
                    "--topicExchange3--" + ++i,new CorrelationData(UUID.randomUUID().toString()));
        }
    }

}
