package com.geektrust.backend.exceptions;

public class RegistrationCancelException extends RuntimeException{
    public RegistrationCancelException() {
        super();
    }

    public RegistrationCancelException(String message) {
        super(message);
    }
}
