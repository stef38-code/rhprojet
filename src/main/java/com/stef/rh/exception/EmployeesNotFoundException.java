package com.stef.rh.exception;

public class EmployeesNotFoundException extends PersonnalNotFoundException {
    public EmployeesNotFoundException(ErrorCode code, Long id) {
        super(code, id);
        detailMessage = "l'employe' avec l'ID %d est introuvable";
    }
}
