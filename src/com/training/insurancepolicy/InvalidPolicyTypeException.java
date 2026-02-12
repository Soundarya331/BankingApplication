package com.training.insurancepolicy;

public class InvalidPolicyTypeException extends RuntimeException {

    public InvalidPolicyTypeException(String message) {
        super(message);
    }
}

