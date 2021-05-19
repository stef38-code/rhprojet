package com.stef.rh.exception;

public class JobsNotFoundException extends PersonnalNotFoundException {
    public JobsNotFoundException(ErrorCode code, Long id) {
        super(code, id);
        detailMessage = "le job avec l'ID %d est introuvable";
    }
}
