package com.stef.rh.exception;

public class JobsNotFoundException extends RuntimeException {
    public JobsNotFoundException(Long id) {
        super(String.format("le job avec l'ID %d est introuvable", id));
    }
}
