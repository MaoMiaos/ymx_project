package com.ymx_project.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQConsumer {

    /**
     * 简单消息的使用类
     * 解析；
     * 为了使用 RabbitMQ 中的消息
     * 我们使用了单独的使用者类来使用简单消息和 json 消息
     * 我们使用了在application.properties文件中配置的相同属性
     * 我们可以使用@RabbitListener注解来提及该方法是侦听器。
     * @param message
     */
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){
        log.info(String.format("Received message -> %s", message));
    }
}
