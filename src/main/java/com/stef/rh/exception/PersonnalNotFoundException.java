package com.stef.rh.exception;

import lombok.Getter;

public class PersonnalNotFoundException extends RuntimeException implements IPersonnalNotFoundException {

    private static final long serialVersionUID = -6833775001657120109L;
    @Getter
    private final ErrorCode code;
    @Getter
    private final Long id;
    protected String detailMessage;

    /*public PersonnalNotFoundException(Long id) {
        super(String.format("le pays avec l'ID %d est introuvable", id));
    }*/


    public PersonnalNotFoundException(ErrorCode code, Long id) {
        super();
        this.code = code;
        this.id = id;
    }

    /*public PersonnalNotFoundException(Long id,String message, Throwable cause, ErrorCode code) {
        super(message, cause);
        this.id = id;
        this.code = code;
    }

    public PersonnalNotFoundException(Long id,String message, ErrorCode code) {
        super(message);
        this.id = id;
        this.code = code;
    }

    public PersonnalNotFoundException(Long id,Throwable cause, ErrorCode code) {
        super(cause);
        this.id = id;
        this.code = code;
    }*/
    @Override
    public String getMessage() {
        return String.format(detailMessage, id);
    }
}
