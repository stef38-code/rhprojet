package com.stef.rh.exception;

import lombok.Getter;

public class PersonnalNotFoundException extends RuntimeException implements IPersonnalNotFoundException {

    private static final long serialVersionUID = -6833775001657120109L;
    @Getter
    private final ErrorCode code;
    @Getter
    private final Long id;
    protected String detailMessage;


    public PersonnalNotFoundException(ErrorCode code, Long id) {
        super();
        this.code = code;
        this.id = id;
    }
    @Override
    public String getMessage() {
        return String.format(detailMessage, id);
    }
}
