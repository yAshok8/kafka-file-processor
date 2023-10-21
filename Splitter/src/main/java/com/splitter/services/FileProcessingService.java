package com.splitter.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FileProcessingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessingService.class);

    @Autowired
    private KafkaProducerService producerService;

    public void processFile(final MultipartFile file) throws IOException {
        LOGGER.info("Started processing the file content.");
        final List<String> headers = new ArrayList<>();
        final List<String> values = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int rowLine = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (rowLine == 0)
                    headers.addAll(Arrays.asList(fields));
                else
                    values.addAll(Arrays.asList(fields));
//                Map<String, String> studentMap = StudentUtilitility.convertToMap(headers, values);
                producerService.sendMessage(values.toString());
                rowLine++;
                values.clear();
            }
        }
    }
}
