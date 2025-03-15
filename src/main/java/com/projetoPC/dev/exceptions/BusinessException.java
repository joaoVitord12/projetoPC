package com.projetoPC.dev.exceptions;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int errorCode = 400;

    public BusinessException(String message) {
        super(message);
    }

    public int getErrorCode() {
        return errorCode;
    }
}