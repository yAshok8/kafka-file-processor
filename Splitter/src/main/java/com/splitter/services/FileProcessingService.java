package com.splitter.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FileProcessingService {

    public void processFile(final MultipartFile file) throws IOException {
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
                rowLine++;
                values.clear();
            }
        }
    }
}
