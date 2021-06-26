package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentsNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        DepartmentsNotFoundException actualDepartmentsNotFoundException = new DepartmentsNotFoundException(
                ErrorCode.TECHNIQUE, 123L);
        assertEquals("com.stef.rh.exception.DepartmentsNotFoundException: le départements avec l'ID 123 est introuvable",
                actualDepartmentsNotFoundException.toString());
        assertEquals(123L, actualDepartmentsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.TECHNIQUE, actualDepartmentsNotFoundException.getCode());
    }

    @Test
    public void testConstructor2() {
        DepartmentsNotFoundException actualDepartmentsNotFoundException = new DepartmentsNotFoundException(
                ErrorCode.APPLICATIF, 123L);
        assertEquals("com.stef.rh.exception.DepartmentsNotFoundException: le départements avec l'ID 123 est introuvable",
                actualDepartmentsNotFoundException.toString());
        assertEquals(123L, actualDepartmentsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.APPLICATIF, actualDepartmentsNotFoundException.getCode());
    }

    @Test
    public void testConstructor3() {
        DepartmentsNotFoundException actualDepartmentsNotFoundException = new DepartmentsNotFoundException(ErrorCode.AUTRE,
                123L);
        assertEquals("com.stef.rh.exception.DepartmentsNotFoundException: le départements avec l'ID 123 est introuvable",
                actualDepartmentsNotFoundException.toString());
        assertEquals(123L, actualDepartmentsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.AUTRE, actualDepartmentsNotFoundException.getCode());
    }
}

