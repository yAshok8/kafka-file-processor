package com.splitter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerSync implements Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerSync.class);
    private String topicName;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ProducerSync(String topicName, KafkaTemplate<String, String> kafkaTemplate) {
        this.topicName = topicName;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Override
    public void sendMessage(String message) {
        LOGGER.info("Sending message to kafka {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
