package com.example.springhillel.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends AbstractException{

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, String messageCode) {
        super(message, messageCode);
    }
}
