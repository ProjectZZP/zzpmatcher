package com.thefuturegroup.zzpmatch;

public class ExceptionWrapper {
    public static RuntimeException wrap(Throwable throwable) {
        if (throwable instanceof RuntimeException) {
            return (RuntimeException) throwable;
        } else {
            return new RuntimeException("Wrapped: " + throwable.getMessage(), throwable);
        }
    }
}
