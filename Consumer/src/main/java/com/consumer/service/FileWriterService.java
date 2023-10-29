package com.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileWriterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @Value("${system.file.path}")
    private String filePath;

    @Value("${system.file.name}")
    private String fileName;


    public void writeToFile(final String content) {
        try {
            File file = new File(filePath + "/" + fileName);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(content); // Write the incoming data to the file
            writer.newLine(); // Append new line
            writer.close();
        } catch (IOException e) {
            LOGGER.error("Could not write to the file,", e);
        }
    }
}
