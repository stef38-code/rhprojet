package com.stef.rh.controller;

import com.stef.rh.exception.ErrorCode;
import com.stef.rh.exception.RegionsNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.LinkedHashMap;

import static org.assertj.core.api.Assertions.assertThat;


class ControllerAdvisorTest {
    @Test
    void testHandleCityNotFoundException() {
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        RegionsNotFoundException ex = new RegionsNotFoundException(ErrorCode.APPLICATIF, 123L);
        ResponseEntity< Object > actualHandleCityNotFoundExceptionResult = controllerAdvisor.handleRegionsNotFoundException(ex,
                new ServletWebRequest(new MockHttpServletRequest()));
        assertThat(((LinkedHashMap) actualHandleCityNotFoundExceptionResult.getBody()).size()).isEqualTo(2);
        assertThat(actualHandleCityNotFoundExceptionResult.hasBody()).isTrue();
        assertThat(actualHandleCityNotFoundExceptionResult.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}

