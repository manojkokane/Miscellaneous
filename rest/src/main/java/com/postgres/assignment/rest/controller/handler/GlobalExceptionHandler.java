package com.postgres.assignment.rest.controller.handler;

import com.postgres.assignment.rest.exception.RecordNotFoundException;
import com.postgres.assignment.rest.exception.util.ExceptionMessage;
import com.postgres.assignment.rest.exception.util.ExceptionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleRecordNotFoundException(RecordNotFoundException ex) {
        ExceptionMessage message = ExceptionUtil.generateMessage(ex.getMessage());
        return new ResponseEntity(message, HttpStatus.NOT_FOUND);
    }
}
