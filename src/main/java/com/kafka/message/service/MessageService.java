package com.kafka.message.service;

import com.kafka.message.entity.MessageLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @Autowired
    SaveMessage saveMessage;

    public MessageLog createMessage(String message){
        MessageLog messageLog = new MessageLog(message);
        saveMessage.saveMessage(messageLog);
        return messageLog;
    }
}
