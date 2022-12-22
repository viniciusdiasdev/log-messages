package com.kafka.message;

import com.kafka.message.entity.MessageLog;
import com.kafka.message.repository.MessageLogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class MessageApplication {

	private static final Logger logger = LoggerFactory.getLogger(MessageApplication.class);

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired MessageLogRepository messageLogRepository){
		return args -> {
			for (int i = 0; i < 1000; i++) {
				MessageLog messageLog = new MessageLog();
				messageLog.setMessage("Mensagem aleatória " + i);
				messageLogRepository.save(messageLog);
				Thread.sleep(1000);
			}
			logger.info("Fim do ciclo");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageApplication.class, args);
	}

}
