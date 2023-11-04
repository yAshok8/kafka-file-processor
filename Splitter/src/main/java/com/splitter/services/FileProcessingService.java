package com.splitter.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.splitter.utils.StringUtility;
import com.splitter.utils.StudentUtility;
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
import java.util.Map;

@Service
public class FileProcessingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessingService.class);

    @Autowired
    private Producer producerService;

    ObjectMapper objectMapper = new ObjectMapper();

    public void processFile(final MultipartFile file) throws IOException {
        LOGGER.info("Started processing the file content.");
        final List<String> headers = new ArrayList<>();
        final List<String> values = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int rowLine = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = StringUtility.getTrimmedValues(line.split(","));
                if (rowLine == 0) {
                    headers.addAll(Arrays.asList(fields));
                } else {
                    values.addAll(Arrays.asList(fields));
                    Map<String, String> studentMap = StudentUtility.convertToMap(headers, values);
                    producerService.sendMessage(objectMapper.writeValueAsString(StudentUtility.getStudentFromMap(studentMap)));
                }
                rowLine++;
                values.clear();
            }
        }
    }
}
