package com.tabakov.ifuture.exception.layer;

public class BusinessLayerException extends RuntimeException {
    public BusinessLayerException(Exception e) {
        super(e.getMessage(), e);
    }
    public BusinessLayerException(String message) {
        super(message);
    }

}
