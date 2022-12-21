package com.kafka.message.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Entity
@Component
public class MessageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private Boolean isRead = false;

    public MessageLog(String message) {
        this.message = message;
    }

    public MessageLog() {

    }

    public MessageLog(Long id, String message, Boolean bool) {
        this.id = id;
        this.message = message;
        this.isRead = bool;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MessageLog{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
