package com.example.producer.controller;


import com.example.producer.cassandra.model.User;
import com.example.producer.cassandra.repository.UserRepository;
import com.example.producer.messages.UserFollowerMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@RestController
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final UserRepository userRepository;

    @Autowired
    public Controller(KafkaTemplate<String, String> kafkaTemplate, UserRepository userRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestParam("name") String name, @RequestParam("lastname") String lastname, @RequestParam(value = "followers") String followers) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(KafkaHeaders.TOPIC, "user-topic");

        User user = new User(name, lastname);

        User u = userRepository.insert(user);

        kafkaTemplate.send(new GenericMessage<>(new UserFollowerMessage(user.getKey().getId().toString(), Arrays.asList(followers.split(","))), headers));
        LOGGER.info("Data - " + user + " sent");

        return ResponseEntity.ok("OK");
    }


}
