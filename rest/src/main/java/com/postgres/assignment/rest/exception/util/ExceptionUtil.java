package com.postgres.assignment.rest.exception.util;

public class ExceptionUtil {

    public static ExceptionMessage generateMessage(String message) {
        return new ExceptionMessage(message);
    }
}
