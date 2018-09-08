package com.chenyh.rabbit.ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.IOException;

/**
 * @Author Henry
 * @Date 8/31/2018
 */
public class MsgAckReceiver {


    /**
     * 消息队列，只接收消息内容
     *
     */
    @RabbitListener(queues = "hello")
    public void receivMsg(int msg, String lmsg, Message message, Channel channel) {
        System.out.println("收到消息：" + msg + "," + lmsg);

        // 确认消息已经消费成功
        try {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);// 确认成功

            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);// 确认失败
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
