package com.consumer.utils;

import com.consumer.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.IOException;

public class StudentUtility {
    private StudentUtility() {
    }

    public static Student getMeAStudent(String studentJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(studentJson, Student.class);
        // Use the Person object for further processing
        return student;
    }

    public static String getLine(Student student) {
        StringBuilder stbr = new StringBuilder();
        stbr.append(student.getName())
                .append(",")
                .append(student.getAge())
                .append(",")
                .append(student.getAddress());
        return stbr.toString();
    }
}
