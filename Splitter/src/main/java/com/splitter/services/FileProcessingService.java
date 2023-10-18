package com.splitter.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class FileProcessingService {

    public void processFile(final MultipartFile file) throws IOException {
        // Create a BufferedReader to read the uploaded CSV file
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line here, e.g., split it into fields
                String[] fields = line.split(",");
                for (String field : fields) {
                    // Process each field as needed
                    System.out.print(field+" | ");
                    // Replace this with your own processing logic
                }
                System.out.println();
            }
        }
    }
}
