package com.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerService {

    @KafkaListener(topics = "your-topic-name")
    public void consume(String message) {
        // Process the received message
        System.out.println("Received message: " + message);
        // Add your business logic here
    }
}
