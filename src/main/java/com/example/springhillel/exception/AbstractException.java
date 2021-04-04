package com.example.springhillel.exception;

import lombok.Getter;

@Getter
public class AbstractException extends RuntimeException{

    private String messageCode;

    public AbstractException(String message) {
        super(message);
    }

    public AbstractException(String message, String messageCode) {
        super(message);
        this.messageCode = messageCode;
    }

}
