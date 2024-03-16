package com.ymx_project.consumer;

import com.ymx_project.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQJsonConsumer {

//    json 消息的使用者类
    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJsonMessage(User user){
        log.info(String.format("Received json mesasge -> %s",user.toString()));
    }
}
