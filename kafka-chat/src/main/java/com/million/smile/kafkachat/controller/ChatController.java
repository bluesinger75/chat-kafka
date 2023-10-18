package com.million.smile.kafkachat.controller;

import com.million.smile.kafkachat.constants.KafkaConstants;
import com.million.smile.kafkachat.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/kafka")
public class ChatController {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping(value = "/publish")
    public void sendMessage(@RequestBody Message message) {
        log.info("Produce message : " + message.toString());

        message.setTimestamp(LocalDateTime.now().toString());
        try {
            //Sending the message to kafka topic queue
            kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    -------------- WebSocket API ----------------
    @MessageMapping("/sendMessage")
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        //Sending this message to all the subscribers
        return message;
    }
}
