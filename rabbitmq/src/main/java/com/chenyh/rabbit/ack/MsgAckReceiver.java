package com.chenyh.rabbit.ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author Henry
 * @Date 8/31/2018
 */
@Component
public class MsgAckReceiver {


    /**
     * 消息队列，只接收消息内容
     *
     */
//    @RabbitListener(queues = "hello")
    public void receivMsg(int msg, String lmsg, Message message, Channel channel) {
        System.out.println("收到消息：" + msg + "," + lmsg);

        // 确认消息已经消费成功
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);// 确认成功
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 消息队列，只接收消息内容
     *
     */
    @RabbitListener(queues = "collectLog")
    public void collectLog1(Message message, Channel channel) {
        System.out.println("收到消息内容1:"+new String(message.getBody()));

        // 确认消息已经消费成功
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);// 确认成功
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    /**
//     * 消息队列，只接收消息内容
//     *
//     */
//    @RabbitListener(queues = "collectLog")
//    public void collectLog2(Message message, Channel channel) {
//        System.out.println("收到消息内容2:"+new String(message.getBody()));
//
//        // 确认消息已经消费成功
//        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);// 确认成功
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * 消息队列，只接收消息内容
//     *
//     */
//    @RabbitListener(queues = "collectLog")
//    public void collectLog3(Message message, Channel channel) {
//        System.out.println("收到消息内容3:"+new String(message.getBody()));
//
//        // 确认消息已经消费成功
//        try {
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);// 确认成功
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
