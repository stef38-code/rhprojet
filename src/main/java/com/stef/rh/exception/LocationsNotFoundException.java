package com.stef.rh.exception;

public class LocationsNotFoundException extends RuntimeException {
    public LocationsNotFoundException(Long id) {
        super(String.format("le emplacement avec l'ID %d est introuvable", id));
    }
}
