package com.example.consumer.service;

import com.example.consumer.cassandra.model.UserFollower;
import com.example.consumer.cassandra.repository.UserFollowerRepository;
import com.example.consumer.messages.UserFollowerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReciever {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReciever.class);

	private final UserFollowerRepository userFollowerRepository;

	public KafkaReciever(UserFollowerRepository userFollowerRepository) {
		this.userFollowerRepository = userFollowerRepository;
	}


	@KafkaListener(topics = "user-topic", groupId = "${spring.kafka.consumer.group-id}")
	public void recieveData(@Payload UserFollowerMessage user) {

		UserFollower userFollower = new UserFollower();
		userFollower.setId(user.getId());
		userFollower.setFollowers(user.getFollowers());
		userFollowerRepository.save(userFollower);

		LOGGER.info("Data - " + user + " recieved");
	}
}