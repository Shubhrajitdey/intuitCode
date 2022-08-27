package com.geektrust.backend.exceptions;

public class MissingDataException extends RuntimeException{
    public MissingDataException() {
        super();
    }

    public MissingDataException(String message) {
        super(message);
    }
}
