package com.ymx_project.controller;

import com.ymx_project.entity.User;
import com.ymx_project.publisher.RabbitMQJsonProducer;
import com.ymx_project.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi")
public class MessageController {
    private RabbitMQProducer rabbitMQProducer;
    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public MessageController(RabbitMQProducer rabbitMQProducer, RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }
//    发布简单消息的 GET 方法
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQProducer.sendMessage(
                message
        );
        return ResponseEntity.ok("Message sent to RabbitMQ.");
    }

//    将 Json 消息发布到队列的 POST 方法。
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ.");
    }
}
