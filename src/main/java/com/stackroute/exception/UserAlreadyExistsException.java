package com.stackroute.exception;

public class UserAlreadyExistsException extends Exception{
    public String message;

    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
