package com.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "${spring.kafka.consumer.topic-name}")
    public void consume(String message) {
        // Process the received message
        LOGGER.info("Received message: {}", message);
    }
}
