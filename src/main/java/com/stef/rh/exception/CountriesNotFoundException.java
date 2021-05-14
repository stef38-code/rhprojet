package com.stef.rh.exception;

public class CountriesNotFoundException extends RuntimeException {
    public CountriesNotFoundException(Long id) {
        super(String.format("le pays avec l'ID %d est introuvable", id));
    }
}
