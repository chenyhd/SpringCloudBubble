package com.chenyh.rabbit.topic;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Receiver {

//    @RabbitListener(queues = "chicken")
    public void process(String lmsg, Message message, Channel channel) throws IOException {
        System.out.println("Receiver1:" + lmsg + "," );
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }

//    @RabbitListener(queues = "chicken")
    public void process3(String lmsg, Message message, Channel channel) throws IOException {
        System.out.println("Receiver requeue:" + lmsg);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
    }

//    @RabbitListener(queues = "hello")
    public void process2(String lmsg, Message message, Channel channel) throws IOException {
        System.out.println("Receiver2:" + lmsg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}