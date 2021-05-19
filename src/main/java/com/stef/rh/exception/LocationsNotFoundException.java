package com.stef.rh.exception;

public class LocationsNotFoundException extends PersonnalNotFoundException {
    public LocationsNotFoundException(ErrorCode code, Long id) {
        super(code, id);
        detailMessage = "le emplacement avec l'ID %d est introuvable";
    }

}
