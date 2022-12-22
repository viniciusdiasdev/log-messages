package com.kafka.message.kafka;

import com.kafka.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    MessageService messageService;

    @KafkaListener(topics = "vini_client", groupId = "client-groupId")
    public void consumer(String message){
        messageService.createMessage(message);
    }
}
