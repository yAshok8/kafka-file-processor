package com.splitter.controller;

import com.splitter.services.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/process")
public class FileProcessingController {

    @Autowired
    private FileProcessingService fileProcessingService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World";
    }

    @PostMapping("/csv")
    public ResponseEntity<String> processCsvFile(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return new ResponseEntity<>("Please select a file to process.", HttpStatus.BAD_REQUEST);
            }
            fileProcessingService.processFile(file);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to process the file.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("File processed successfully.", HttpStatus.OK);
    }
}
