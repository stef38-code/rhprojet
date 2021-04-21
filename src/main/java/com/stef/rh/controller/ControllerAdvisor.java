package com.stef.rh.controller;

import com.stef.rh.exception.RegionsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RegionsNotFoundException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            RegionsNotFoundException ex, WebRequest request) {

        Map< String, Object > body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", "Région spécifiée est introuvable");
        log.error("message erreur:{}", ex.getMessage());
        log.error("url:{}", request.getContextPath());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
