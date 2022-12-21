package com.kafka.message.repository;

import com.kafka.message.entity.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {

    @Query(
            value = "select * from MESSAGE_LOG m where m.IS_READ = FALSE",
            nativeQuery = true)
    List<MessageLog> findAllMessagesNotLog();

    @Query(
            value = "select * from MESSAGE_LOG m where m.IS_READ = FALSE",
            nativeQuery = true)
    List<MessageLog> findOneMessageNotLog();
}
