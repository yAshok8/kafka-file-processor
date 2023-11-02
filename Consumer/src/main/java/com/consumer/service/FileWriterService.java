package com.consumer.service;

import com.consumer.model.Student;
import com.consumer.utils.StudentUtility;
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
            LOGGER.info("Writing data to the file. {}", content);
            File file = new File(filePath + "/" + fileName);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            Student student = StudentUtility.getMeAStudent(content);
            String fileLineContent = StudentUtility.getLine(student);
            writer.write(fileLineContent);
            writer.newLine();
            writer.close(); //This could be heavy operation. Search if this can be optimized further.
        } catch (IOException e) {
            LOGGER.error("Could not write to the file,", e);
        }
    }
}
