package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DependantsNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        DependantsNotFoundException actualDependantsNotFoundException = new DependantsNotFoundException(ErrorCode.TECHNIQUE,
                123L);
        assertEquals(
                "com.stef.rh.exception.DependantsNotFoundException: La personne à charge avec l'ID 123 est" + " introuvable",
                actualDependantsNotFoundException.toString());
        assertEquals(123L, actualDependantsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.TECHNIQUE, actualDependantsNotFoundException.getCode());
    }

    @Test
    public void testConstructor2() {
        DependantsNotFoundException actualDependantsNotFoundException = new DependantsNotFoundException(
                ErrorCode.APPLICATIF, 123L);
        assertEquals(
                "com.stef.rh.exception.DependantsNotFoundException: La personne à charge avec l'ID 123 est" + " introuvable",
                actualDependantsNotFoundException.toString());
        assertEquals(123L, actualDependantsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.APPLICATIF, actualDependantsNotFoundException.getCode());
    }

    @Test
    public void testConstructor3() {
        DependantsNotFoundException actualDependantsNotFoundException = new DependantsNotFoundException(ErrorCode.AUTRE,
                123L);
        assertEquals(
                "com.stef.rh.exception.DependantsNotFoundException: La personne à charge avec l'ID 123 est" + " introuvable",
                actualDependantsNotFoundException.toString());
        assertEquals(123L, actualDependantsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.AUTRE, actualDependantsNotFoundException.getCode());
    }
}

