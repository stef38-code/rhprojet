package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RegionsNotFoundExceptionTest {
    @Test
    void testConstructor() {
        RegionsNotFoundException actualRegionsNotFoundException = new RegionsNotFoundException(ErrorCode.APPLICATIF, 123L);
        assertAll(() -> {
            assertThat(actualRegionsNotFoundException.getCause()).isNull();
            assertThat(actualRegionsNotFoundException.toString()).isEqualToIgnoringCase("com.stef.rh.exception.RegionsNotFoundException: la région avec l'ID 123 est introuvable");
            assertThat(actualRegionsNotFoundException.getSuppressed()).isEmpty();
            assertThat(actualRegionsNotFoundException.getMessage()).isEqualToIgnoringCase("la région avec l'ID 123 est introuvable");
            assertThat(actualRegionsNotFoundException.getLocalizedMessage()).isEqualToIgnoringCase("la région avec l'ID 123 est introuvable");
        });
    }

    @Test
    public void testConstructor2() {
        RegionsNotFoundException actualRegionsNotFoundException = new RegionsNotFoundException(ErrorCode.TECHNIQUE, 123L);
        assertThat(actualRegionsNotFoundException.toString()).isEqualTo("com.stef.rh.exception.RegionsNotFoundException: la région avec l'ID 123 est introuvable");
        assertThat(actualRegionsNotFoundException.getId().longValue()).isEqualTo(123L);
        assertThat(actualRegionsNotFoundException.getCode()).isEqualTo(ErrorCode.TECHNIQUE);
    }

    @Test
    public void testConstructor3() {
        RegionsNotFoundException actualRegionsNotFoundException = new RegionsNotFoundException(ErrorCode.APPLICATIF, 123L);
        assertThat(actualRegionsNotFoundException.toString()).isEqualTo("com.stef.rh.exception.RegionsNotFoundException: la région avec l'ID 123 est introuvable");
        assertThat(actualRegionsNotFoundException.getId().longValue()).isEqualTo(123L);
        assertThat(actualRegionsNotFoundException.getCode()).isEqualTo(ErrorCode.APPLICATIF);
    }

    @Test
    public void testConstructor4() {
        RegionsNotFoundException actualRegionsNotFoundException = new RegionsNotFoundException(ErrorCode.AUTRE, 123L);
        assertThat(actualRegionsNotFoundException.toString()).isEqualTo("com.stef.rh.exception.RegionsNotFoundException: la région avec l'ID 123 est introuvable");
        assertThat(actualRegionsNotFoundException.getId().longValue()).isEqualTo(123L);
        assertThat(actualRegionsNotFoundException.getCode()).isEqualTo(ErrorCode.AUTRE);
    }
}

