package com.stef.rh.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JobsNotFoundExceptionTest {
    @Test
    public void testConstructor() {
        JobsNotFoundException actualJobsNotFoundException = new JobsNotFoundException(ErrorCode.TECHNIQUE, 123L);
        assertEquals("com.stef.rh.exception.JobsNotFoundException: le job avec l'ID 123 est introuvable",
                actualJobsNotFoundException.toString());
        assertEquals(123L, actualJobsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.TECHNIQUE, actualJobsNotFoundException.getCode());
    }

    @Test
    public void testConstructor2() {
        JobsNotFoundException actualJobsNotFoundException = new JobsNotFoundException(ErrorCode.APPLICATIF, 123L);
        assertEquals("com.stef.rh.exception.JobsNotFoundException: le job avec l'ID 123 est introuvable",
                actualJobsNotFoundException.toString());
        assertEquals(123L, actualJobsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.APPLICATIF, actualJobsNotFoundException.getCode());
    }

    @Test
    public void testConstructor3() {
        JobsNotFoundException actualJobsNotFoundException = new JobsNotFoundException(ErrorCode.AUTRE, 123L);
        assertEquals("com.stef.rh.exception.JobsNotFoundException: le job avec l'ID 123 est introuvable",
                actualJobsNotFoundException.toString());
        assertEquals(123L, actualJobsNotFoundException.getId().longValue());
        assertEquals(ErrorCode.AUTRE, actualJobsNotFoundException.getCode());
    }
}

