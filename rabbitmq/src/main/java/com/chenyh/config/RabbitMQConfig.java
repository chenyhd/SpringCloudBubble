package com.chenyh.config;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {




    @Bean
    @ConfigurationProperties(prefix = "spring.rabbitmq")
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("collectLog");
//        container.setMessageListener(listenerAdapter);
        container.setConcurrentConsumers(2);
        container.setMaxConcurrentConsumers(5);
        container.setMessageListener((MessageListener) message -> System.out.println(new String(message.getBody())));
        return container;
    }



}
