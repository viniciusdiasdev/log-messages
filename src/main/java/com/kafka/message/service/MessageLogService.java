package com.kafka.message.service;

import com.kafka.message.entity.MessageLog;
import com.kafka.message.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageLogService {


    @Autowired
    MessageLogRepository messageLogRepository;

    @Autowired
    UpdateData updateData;

    public List<MessageLog> findAll(){
        List<MessageLog> allMessagesNotLog = messageLogRepository.findByIsReadIsFalse();
        allMessagesNotLog.forEach(messageLog -> updateData.updateMessage(messageLog));
        return allMessagesNotLog;
    }
}
