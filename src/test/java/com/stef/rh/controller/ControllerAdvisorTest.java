package com.stef.rh.controller;

import com.stef.rh.exception.RegionsNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControllerAdvisorTest {
    @Test
    void testHandleCityNotFoundException() {
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        RegionsNotFoundException ex = new RegionsNotFoundException(123L);
        ResponseEntity< Object > actualHandleCityNotFoundExceptionResult = controllerAdvisor.handleCityNotFoundException(ex,
                new ServletWebRequest(new MockHttpServletRequest()));
        assertEquals(2, ((LinkedHashMap) actualHandleCityNotFoundExceptionResult.getBody()).size());
        assertTrue(actualHandleCityNotFoundExceptionResult.hasBody());
        assertEquals(HttpStatus.NOT_FOUND, actualHandleCityNotFoundExceptionResult.getStatusCode());
    }
}

