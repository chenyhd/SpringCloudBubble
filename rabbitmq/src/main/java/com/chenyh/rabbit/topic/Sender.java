package com.chenyh.rabbit.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send1(String msg) {
        System.out.println("Sender : " + msg);
        rabbitTemplate.convertAndSend("message","hello.chicken.fried",msg);
    }



}