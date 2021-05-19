package com.stef.rh.exception;

public class RegionsNotFoundException extends PersonnalNotFoundException {
    public RegionsNotFoundException(ErrorCode code, Long id) {
        super(code, id);
        detailMessage = "la région avec l'ID %d est introuvable";
    }
}
