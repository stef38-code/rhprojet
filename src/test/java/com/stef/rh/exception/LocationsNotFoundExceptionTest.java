package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationsNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        LocationsNotFoundException actualLocationsNotFoundException = new LocationsNotFoundException(ErrorCode.TECHNIQUE,
                123L);
        assertEquals("com.stef.rh.exception.LocationsNotFoundException: le emplacement avec l'ID 123 est introuvable",
                actualLocationsNotFoundException.toString());
        assertEquals(123L, actualLocationsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.TECHNIQUE, actualLocationsNotFoundException.getCode());
    }

    @Test
    public void testConstructor2() {
        LocationsNotFoundException actualLocationsNotFoundException = new LocationsNotFoundException(ErrorCode.APPLICATIF,
                123L);
        assertEquals("com.stef.rh.exception.LocationsNotFoundException: le emplacement avec l'ID 123 est introuvable",
                actualLocationsNotFoundException.toString());
        assertEquals(123L, actualLocationsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.APPLICATIF, actualLocationsNotFoundException.getCode());
    }

    @Test
    public void testConstructor3() {
        LocationsNotFoundException actualLocationsNotFoundException = new LocationsNotFoundException(ErrorCode.AUTRE, 123L);
        assertEquals("com.stef.rh.exception.LocationsNotFoundException: le emplacement avec l'ID 123 est introuvable",
                actualLocationsNotFoundException.toString());
        assertEquals(123L, actualLocationsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.AUTRE, actualLocationsNotFoundException.getCode());
    }
}

