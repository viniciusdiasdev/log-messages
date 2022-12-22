package com.kafka.message.service;

import com.kafka.message.entity.MessageLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoggerService {

    @Autowired
    MessageLogService messageLogService;

    private List<MessageLog> messageLogList = new ArrayList<>();

    private static final Logger logger = LoggerFactory.getLogger(LoggerService.class);

    public void loggMessages(){
        List<MessageLog> messageLogList = messageLogService.findAll();
        messageLogList.forEach(messageLog -> logger.info(messageLog.toString()));
    }

    @Scheduled(fixedDelay = 5000)
    public void run(){
        loggMessages();
    }
}
