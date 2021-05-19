package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonnalNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        PersonnalNotFoundException actualPersonnalNotFoundException = new PersonnalNotFoundException(ErrorCode.TECHNIQUE,
                123L);
        assertEquals(123L, actualPersonnalNotFoundException.getId().longValue());
        assertEquals(ErrorCode.TECHNIQUE, actualPersonnalNotFoundException.getCode());
    }

    @Test
    public void testConstructor2() {
        PersonnalNotFoundException actualPersonnalNotFoundException = new PersonnalNotFoundException(ErrorCode.APPLICATIF,
                123L);
        assertEquals(123L, actualPersonnalNotFoundException.getId().longValue());
        assertEquals(ErrorCode.APPLICATIF, actualPersonnalNotFoundException.getCode());
    }

    @Test
    public void testConstructor3() {
        PersonnalNotFoundException actualPersonnalNotFoundException = new PersonnalNotFoundException(ErrorCode.AUTRE, 123L);
        assertEquals(123L, actualPersonnalNotFoundException.getId().longValue());
        assertEquals(ErrorCode.AUTRE, actualPersonnalNotFoundException.getCode());
    }
}

