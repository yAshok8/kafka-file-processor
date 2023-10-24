package com.splitter.utils;

public class StringUtility {

    private StringUtility() {}

    public static String [] getTrimmedValues(final String [] values) {
        String [] res = new String[values.length];
        int count = 0;
        for (String value: values) {
            res[count++] = value.trim();
        }
        return res;
    }
}
