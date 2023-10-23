package com.splitter.utils;

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
}
