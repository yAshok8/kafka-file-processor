package com.splitter.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
@Builder
public class Student {
    private String name;
    private int age;
    private String address;
    private Map<Subject, Integer> subjectMarks;
}
