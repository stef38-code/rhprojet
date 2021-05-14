package com.stef.rh.exception;

public class DependantsNotFoundException extends RuntimeException {
    public DependantsNotFoundException(Long id) {
        super(String.format("La personne à charge avec l'ID %d est introuvable", id));
    }
}
