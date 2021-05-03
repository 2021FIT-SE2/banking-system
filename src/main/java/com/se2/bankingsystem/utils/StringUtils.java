package com.se2.bankingsystem.utils;

public class StringUtils {
    public static String lowerFirstLetter(String string) {
        char[] c = string.toCharArray();
        c[0] += 32;
        return new String(c);
    }
}
