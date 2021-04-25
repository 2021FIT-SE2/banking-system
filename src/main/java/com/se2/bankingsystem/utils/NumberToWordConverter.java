package com.se2.bankingsystem.utils;

import java.util.HashMap;
import java.util.Map;

public class NumberToWordConverter {
    private static final Map<Integer, String> translations = new HashMap<>();

    static {
        translations.put(1, "one");
        translations.put(2, "two");
        translations.put(3, "three");
        translations.put(4, "four");
        translations.put(5, "five");
        translations.put(6, "six");
        translations.put(7, "seven");
        translations.put(8, "eight");
        translations.put(9, "nine");
        translations.put(10, "ten");
        translations.put(11, "eleven");
        translations.put(12, "twelve");
        translations.put(18, "eighteen");
        translations.put(24, "twenty four");
    }

    public static String convert(int number) {
        return translations.get(number);
    }
}
