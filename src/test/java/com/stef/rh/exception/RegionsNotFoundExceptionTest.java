package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class RegionsNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        RegionsNotFoundException actualRegionsNotFoundException = new RegionsNotFoundException(123L);
        assertNull(actualRegionsNotFoundException.getCause());
        assertEquals("com.stef.rh.exception.RegionsNotFoundException: la région avec l'ID 123 est introuvable",
                actualRegionsNotFoundException.toString());
        assertEquals(0, actualRegionsNotFoundException.getSuppressed().length);
        assertEquals("la région avec l'ID 123 est introuvable", actualRegionsNotFoundException.getMessage());
        assertEquals("la région avec l'ID 123 est introuvable", actualRegionsNotFoundException.getLocalizedMessage());
    }
}

