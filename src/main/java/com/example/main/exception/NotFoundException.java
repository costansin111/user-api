package com.example.main.exception;

public class NotFoundException extends RuntimeException{

    private static final String NO_SUCH_ID = "NO_SUCH_ID";

    public NotFoundException() {
        super(NO_SUCH_ID);
    }
}
