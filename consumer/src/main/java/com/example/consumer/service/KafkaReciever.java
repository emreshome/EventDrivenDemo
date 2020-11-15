package com.example.consumer.service;

import com.example.consumer.messages.UserFollowerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReciever {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReciever.class);

	@KafkaListener(topics = "user-topic", groupId = "${spring.kafka.consumer.group-id}")
	public void recieveData(@Payload UserFollowerMessage user) {
		LOGGER.info("Data - " + user + " recieved");
	}
}