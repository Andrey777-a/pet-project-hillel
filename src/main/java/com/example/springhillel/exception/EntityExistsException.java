package com.example.springhillel.exception;

import lombok.Getter;

@Getter
public class EntityExistsException extends AbstractException{

    public EntityExistsException(String message) {
        super(message);
    }

    public EntityExistsException(String messageCode, String massage) {
        super(messageCode, massage);
    }
}
