package com.chenyh.controller;

import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by fuwei.deng on 2017年7月24日.
 */
@RestController
@RequestMapping("rabbitmq/listener")
public class RabbitMQController {

    @Resource
    private RabbitListenerEndpointRegistry rabbitListenerEndpointRegistry;

    @RequestMapping("stop")
    public String stop(){
        rabbitListenerEndpointRegistry.stop();
        return "success";
    }

    @RequestMapping("start")
    public String start(){
        rabbitListenerEndpointRegistry.start();
        return "success";
    }

    @RequestMapping("setup")
    public String setup(int consumer, int maxConsumer){
        Set<String> containerIds = rabbitListenerEndpointRegistry.getListenerContainerIds();
        SimpleMessageListenerContainer container = null;
        for(String id : containerIds){
            container = (SimpleMessageListenerContainer) rabbitListenerEndpointRegistry.getListenerContainer(id);
            if(container != null){
                container.setConcurrentConsumers(consumer);
                container.setMaxConcurrentConsumers(maxConsumer);
            }
        }
        return "success";
    }

}
