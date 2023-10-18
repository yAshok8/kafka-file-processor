package com.splitter.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class Student {
    private String name;
    private int age;
    private String address;
    private Map<Subject, Integer> subjectMarks;
}
