package com.hodge.daniel;

public class BatchAlreadyFullException extends Exception {
    public BatchAlreadyFullException() {
    }

    public BatchAlreadyFullException(String message) {
        super(message);
    }

    public BatchAlreadyFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
