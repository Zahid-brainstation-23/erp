package com.brainstation23.erp.exception.custom.custom;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccessException  extends RuntimeException{
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
