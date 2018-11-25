package com.chenyh.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 使用Jackson 序列化和反序列化
     * @param connectionFactory
     * @return
     */
//    @Bean
//    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        return factory;
//    }


    @Bean
    public Queue helloQueue() {
        return new Queue("topicHello");
    }

    @Bean
    public Queue chickenQueue() {
        return new Queue("topicChicken");
    }

    /**
     * 声明一个topic类型的exchange
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return  new TopicExchange("topicExchange");
    }

    /**
     *  exchange 和 queue 绑定
     *  使用 topicExample exchange 来解析 routingKey 如果满足 hello.# 则将信息添加到 topicHello 队列中
     *  @param helloQueue
     * @param topicExchange
     */
    @Bean
    public Binding Binding1(Queue helloQueue, TopicExchange topicExchange){
        return BindingBuilder.bind(helloQueue).to(topicExchange).with("hello.#");
    }

    /**
     *  exchange 和 queue 绑定
     *  使用 topicExample exchange 来解析 routingKey 如果满足 hello.chicken.# 则将信息添加到 topicHello 队列中
     *  @param chickenQueue
     * @param topicExample
     */
    @Bean
    public Binding Binding2(Queue chickenQueue, TopicExchange topicExample){
        return BindingBuilder.bind(chickenQueue).to(topicExample).with("hello.chicken.#");
    }

}
