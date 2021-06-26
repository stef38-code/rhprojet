package com.stef.rh.exception;

public class DepartmentsNotFoundException extends PersonnalNotFoundException {

    public DepartmentsNotFoundException(ErrorCode code, Long id) {
        super(code, id);
        detailMessage = "le départements avec l'ID %d est introuvable";
    }
}
