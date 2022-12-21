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

    private MessageLog testeMessage;

    public List<MessageLog> findAll(){
        List<MessageLog> allMessagesNotLog = messageLogRepository.findAllMessagesNotLog();
        allMessagesNotLog.forEach(messageLog -> updateData.updateMessage(messageLog));
        allMessagesNotLog.forEach(messageLog -> testeMessage = messageLog);
        return allMessagesNotLog;
    }

    public MessageLog getOne(){
        List<MessageLog> allMessagesNotLog = messageLogRepository.findAllMessagesNotLog();
        allMessagesNotLog.forEach(messageLog -> updateData.updateMessage(messageLog));
        allMessagesNotLog.forEach(messageLog -> testeMessage = messageLog);
        return testeMessage;
    }
}
