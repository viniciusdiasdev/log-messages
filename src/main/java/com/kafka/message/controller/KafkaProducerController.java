package com.kafka.message.controller;

import com.kafka.message.service.MessageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    MessageLogService messageLogService;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/producer/{message}")
    public void producer(@PathVariable("message") String message){
        this.kafkaTemplate.send("vini_client",message);
    }

    @GetMapping("messages")
    public void listAllMessages(){
        messageLogService.findAll();
    }
}
