package com.stef.rh.exception;

public class DepartmentsNotFoundException extends RuntimeException {
    public DepartmentsNotFoundException(Long id) {
        super(String.format("le départements avec l'ID %d est introuvable", id));
    }
}
