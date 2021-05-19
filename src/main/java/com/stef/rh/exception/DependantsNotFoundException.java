package com.stef.rh.exception;

public class DependantsNotFoundException extends PersonnalNotFoundException {
    public DependantsNotFoundException(ErrorCode code, Long id) {
        super(code, id);
        detailMessage = "La personne à charge avec l'ID %d est introuvable";
    }
}
