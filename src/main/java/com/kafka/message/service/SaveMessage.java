package com.kafka.message.service;

import com.kafka.message.entity.MessageLog;
import com.kafka.message.repository.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SaveMessage {

    private static final Logger logger = LoggerFactory.getLogger(SaveMessage.class);


    @Autowired
    MessageLogRepository messageLogRepository;

    @Autowired
    UpdateData updateData;
    public void saveMessage(MessageLog messageLog){
        messageLogRepository.save(messageLog);
        logger.info("mensagem salva no banco.");
    }
}
