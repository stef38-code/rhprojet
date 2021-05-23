package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

 class CountriesNotFoundExceptionTest {
    @Test
    void testConstructor() {
       CountriesNotFoundException actualCountriesNotFoundException = new CountriesNotFoundException(ErrorCode.TECHNIQUE,
               123L);
       assertThat(actualCountriesNotFoundException.toString()).hasToString("com.stef.rh.exception.CountriesNotFoundException: le pays avec l'ID 123 est introuvable");
       assertThat(actualCountriesNotFoundException.getId().longValue()).isEqualTo(123L);
       assertThat(actualCountriesNotFoundException.getCode()).isEqualTo(ErrorCode.TECHNIQUE);
    }

    @Test
    void testConstructor2() {
       CountriesNotFoundException actualCountriesNotFoundException = new CountriesNotFoundException(ErrorCode.APPLICATIF,
               123L);
       assertThat(actualCountriesNotFoundException.toString()).hasToString("com.stef.rh.exception.CountriesNotFoundException: le pays avec l'ID 123 est introuvable");
       assertThat(actualCountriesNotFoundException.getId().longValue()).isEqualTo(123L);
       assertThat(actualCountriesNotFoundException.getCode()).isEqualTo(ErrorCode.APPLICATIF);
    }

    @Test
    void testConstructor3() {
       CountriesNotFoundException actualCountriesNotFoundException = new CountriesNotFoundException(ErrorCode.AUTRE, 123L);
       assertThat(actualCountriesNotFoundException.toString()).hasToString("com.stef.rh.exception.CountriesNotFoundException: le pays avec l'ID 123 est introuvable");
       assertThat(actualCountriesNotFoundException.getId().longValue()).isEqualTo(123L);
       assertThat(actualCountriesNotFoundException.getCode()).isEqualTo(ErrorCode.AUTRE);
    }
}

