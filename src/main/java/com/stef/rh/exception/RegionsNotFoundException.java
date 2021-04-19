package com.stef.rh.exception;

public class RegionsNotFoundException extends RuntimeException{
    public RegionsNotFoundException(Long id) {
        super(String.format("la région avec l'ID %d est introuvable", id));
    }
}
