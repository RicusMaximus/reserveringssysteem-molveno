package com.hotel.reservationsystem.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException (String message) {
        super(message);
    }
}
