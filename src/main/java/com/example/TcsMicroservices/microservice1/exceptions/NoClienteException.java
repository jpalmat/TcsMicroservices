package com.example.TcsMicroservices.microservice1.exceptions;

public class NoClienteException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoClienteException(String message) {
        super(message);
    }
}
