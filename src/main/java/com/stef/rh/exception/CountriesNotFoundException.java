package com.stef.rh.exception;

public class CountriesNotFoundException extends PersonnalNotFoundException {
    public CountriesNotFoundException(ErrorCode code, Long id) {
        super(code, id);
        detailMessage = "le pays avec l'ID %d est introuvable";
    }

}