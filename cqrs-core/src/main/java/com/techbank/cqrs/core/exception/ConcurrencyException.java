package com.techbank.cqrs.core.exception;

public class ConcurrencyException extends RuntimeException {
    private  static final String MESSAGE="Concurrency exception";
    public ConcurrencyException() {
        super(MESSAGE);
    }
}
