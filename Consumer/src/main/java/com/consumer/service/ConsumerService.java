package com.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    private FileWriterService fileWriterService;

    @KafkaListener(topics = "${spring.kafka.consumer.topic-name}")
    public void consume(String message) {
        //send the student information for adding to the file.
        fileWriterService.writeToFile(message);
    }
}
