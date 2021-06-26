package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        EmployeesNotFoundException actualEmployeesNotFoundException = new EmployeesNotFoundException(ErrorCode.TECHNIQUE,
                123L);
        assertEquals("com.stef.rh.exception.EmployeesNotFoundException: l'employe' avec l'ID 123 est introuvable",
                actualEmployeesNotFoundException.toString());
        assertEquals(123L, actualEmployeesNotFoundException.getId().longValue());
        assertEquals(ErrorCode.TECHNIQUE, actualEmployeesNotFoundException.getCode());
    }

    @Test
    public void testConstructor2() {
        EmployeesNotFoundException actualEmployeesNotFoundException = new EmployeesNotFoundException(ErrorCode.APPLICATIF,
                123L);
        assertEquals("com.stef.rh.exception.EmployeesNotFoundException: l'employe' avec l'ID 123 est introuvable",
                actualEmployeesNotFoundException.toString());
        assertEquals(123L, actualEmployeesNotFoundException.getId().longValue());
        assertEquals(ErrorCode.APPLICATIF, actualEmployeesNotFoundException.getCode());
    }

    @Test
    public void testConstructor3() {
        EmployeesNotFoundException actualEmployeesNotFoundException = new EmployeesNotFoundException(ErrorCode.AUTRE, 123L);
        assertEquals("com.stef.rh.exception.EmployeesNotFoundException: l'employe' avec l'ID 123 est introuvable",
                actualEmployeesNotFoundException.toString());
        assertEquals(123L, actualEmployeesNotFoundException.getId().longValue());
        assertEquals(ErrorCode.AUTRE, actualEmployeesNotFoundException.getCode());
    }
}

