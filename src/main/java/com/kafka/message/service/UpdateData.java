package com.kafka.message.service;

import com.kafka.message.entity.MessageLog;
import com.kafka.message.repository.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateData {

    private static final Logger logger = LoggerFactory.getLogger(UpdateData.class);

    @Autowired
    MessageLogRepository messageLogRepository;

    public void updateMessage(MessageLog messageLog){
        MessageLog updpateMessage = new MessageLog(messageLog.getId() ,messageLog.getMessage(), Boolean.TRUE);
        messageLogRepository.save(updpateMessage);
        logger.info("mensagem sofreu update");
    }
}
