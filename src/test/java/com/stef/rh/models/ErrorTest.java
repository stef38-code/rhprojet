package com.stef.rh.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorTest {
    @Test
    public void testCode() {
        Error error = new Error();
        Error actualCodeResult = error.code("Code");
        assertSame(error, actualCodeResult);
        assertEquals("Code", actualCodeResult.getCode());
    }

    @Test
    public void testSetCode() {
        Error error = new Error();
        error.setCode("Code");
        assertEquals("Code", error.getCode());
    }

    @Test
    public void testMessage() {
        Error error = new Error();
        Error actualMessageResult = error.message("Not all who wander are lost");
        assertSame(error, actualMessageResult);
        assertEquals("Not all who wander are lost", actualMessageResult.getMessage());
    }

    @Test
    public void testSetMessage() {
        Error error = new Error();
        error.setMessage("Not all who wander are lost");
        assertEquals("Not all who wander are lost", error.getMessage());
    }

    @Test
    public void testEquals() {
        assertFalse((new Error()).equals("42"));
        assertFalse((new Error()).equals(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(961, (new Error()).hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("class Error {\n    code: null\n    message: null\n}", (new Error()).toString());
    }

    @Test
    public void testToString2() {
        Error error = new Error();
        error.setMessage("Not all who wander are lost");
        assertEquals("class Error {\n    code: null\n    message: Not all who wander are lost\n}", error.toString());
    }
}

