package com.consumer.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Student {
    private String name;
    private int age;
    private String address;
    private Map<String, Integer> subjectMarks;
}
