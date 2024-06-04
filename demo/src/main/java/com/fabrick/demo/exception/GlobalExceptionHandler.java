package com.fabrick.demo.exception;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<JsonNode> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
//        log.error("Handler - TypeMismatch - Error");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode errors = mapper.createObjectNode()
                .put("error", "TypeMismatch")
                .put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(errors);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<JsonNode> handleIllegalArgumentException(IllegalArgumentException ex) {
//        log.error("Handler - IllegalArgument - Error");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode errors = mapper.createObjectNode()
                .put("error", "IllegalArgument")
                .put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(errors);
    }

}