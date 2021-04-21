package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RegionsNotFoundExceptionTest {
    @Test
    void testConstructor() {
        RegionsNotFoundException actualRegionsNotFoundException = new RegionsNotFoundException(123L);
        assertAll(() -> {
            assertThat(actualRegionsNotFoundException.getCause()).isNull();
            assertThat(actualRegionsNotFoundException.toString()).isEqualToIgnoringCase("com.stef.rh.exception.RegionsNotFoundException: la région avec l'ID 123 est introuvable");
            assertThat(actualRegionsNotFoundException.getSuppressed()).isEmpty();
            assertThat(actualRegionsNotFoundException.getMessage()).isEqualToIgnoringCase("la région avec l'ID 123 est introuvable");
            assertThat(actualRegionsNotFoundException.getLocalizedMessage()).isEqualToIgnoringCase("la région avec l'ID 123 est introuvable");
        });
    }
}

