package com.stef.rh.exception;

public class EmployeesNotFoundException extends RuntimeException {
    public EmployeesNotFoundException(Long id) {
        super(String.format("l'employe' avec l'ID %d est introuvable", id));
    }
}
