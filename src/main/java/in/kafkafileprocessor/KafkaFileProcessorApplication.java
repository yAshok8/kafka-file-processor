package com.splitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SplitterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SplitterApplication.class, args);
    }
}
