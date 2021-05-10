package com.stef.rh.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorTest {
    @Test
    void testCode() {
        Error error = new Error();
        Error actualCodeResult = error.code("Code");
        assertThat(actualCodeResult).isSameAs(error);
        assertThat(actualCodeResult.getCode()).isEqualTo("Code");
    }

    @Test
    void testSetCode() {
       Error error = new Error();
        error.setCode("Code");
        assertThat(error.getCode()).isEqualTo("Code");
    }

    @Test
    void testMessage() {
        Error error = new Error();
        Error actualMessageResult = error.message("Not all who wander are lost");
        assertThat(actualMessageResult).isSameAs(error);
        assertThat(actualMessageResult.getMessage()).isEqualTo("Not all who wander are lost");
    }

    @Test
    void testSetMessage() {
       Error error = new Error();
        error.setMessage("Not all who wander are lost");
        assertThat(error.getMessage()).hasToString("Not all who wander are lost");
    }


    @Test
    void testHashCode() {
        assertThat((new Error()).hashCode()).isEqualTo(961);
    }

    @Test
    void testToString() {
        assertThat((new Error()).toString()).hasToString("class Error {\n    code: null\n    message: null\n}");
    }

    @Test
    void testToString2() {
       Error error = new Error();
        error.setMessage("Not all who wander are lost");
        assertThat(error.toString()).hasToString("class Error {\n    code: null\n    message: Not all who wander are lost\n}");
    }
}

