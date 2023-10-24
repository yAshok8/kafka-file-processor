package com.splitter.utils;

import com.splitter.model.Student;
import com.splitter.model.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentUtility {

    private StudentUtility() {}

    public static Map<String, String> convertToMap(final List<String> header, final List<String> values) {
        Map<String, String> result = new HashMap<>();
        for (int i=0; i<header.size(); i++) {
            result.put(header.get(i), values.get(i));
        }
        return result;
    }

    public static Student getStudentFromMap(final Map<String, String> map) {
        Map<Subject, Integer> marks = new HashMap<>();
        marks.put(Subject.MATHS, Integer.parseInt(map.get("Maths")));
        marks.put(Subject.ENGLISH, Integer.parseInt(map.get("English")));
        marks.put(Subject.SCIENCE, Integer.parseInt(map.get("Science")));
        marks.put(Subject.HISTORY, Integer.parseInt(map.get("History")));
        marks.put(Subject.GEOGRAPHY, Integer.parseInt(map.get("Geography")));
        Student student = Student.builder().name(map.get("Name"))
                .age(Integer.parseInt(map.get("Age")))
                .address(map.get("Address"))
                .subjectMarks(marks)
                .build();
        return student;
    }
}
