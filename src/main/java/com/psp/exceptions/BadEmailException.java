package com.psp.exceptions;

public class BadEmailException extends IllegalArgumentException {

    public BadEmailException(String message) {
        super(message);
    }
}
