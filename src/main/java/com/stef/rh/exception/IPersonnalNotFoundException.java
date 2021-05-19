package com.stef.rh.exception;

import java.io.Serializable;

public interface IPersonnalNotFoundException extends Serializable {
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
    String getMessage();

    ErrorCode getCode();

    Long getId();
}
