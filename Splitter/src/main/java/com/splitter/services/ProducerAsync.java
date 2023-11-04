package com.splitter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;

public class ProducerAsync implements Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerAsync.class);
    private String topicName;
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    public ProducerAsync(String topicName, KafkaTemplate<String, String> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Async
    @Override
    public void sendMessage(String message) {
        LOGGER.info("Sending message to kafka {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
