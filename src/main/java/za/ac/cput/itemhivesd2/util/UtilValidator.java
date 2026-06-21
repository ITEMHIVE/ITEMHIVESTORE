package za.ac.cput.util;

import java.time.LocalDate;
/*
UtilValidator.java
Util Validator  model class
Author:Athini Ngquke(222352302)
Date: 26 March 2026
 */
public class UtilValidator {
    public static void requireNotNullorEmpty(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty");
        }
    }

    public static void requireNotZero(double value, String fieldName) {
        if (value <= 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative");
        }
    }

    public static void requireNoPreviousDate(LocalDate value, String fieldName) {
        if (value.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException(fieldName + " cannot be in the past");
        }
    }

    public static void requireNoFutureDate(LocalDate value, String fieldName) {
        if (value.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(fieldName + " cannot be in the future");
        }
    }
    public static void requireNotNull(LocalDate value, String fieldName){
        if(value == null){
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }

    }
}
