package com.tabakov.ifuture.exception;

import com.tabakov.ifuture.exception.layer.BusinessLayerException;

public class AccountNotFoundException extends BusinessLayerException {
    public AccountNotFoundException(int id) {
        super(String.valueOf(id));
    }
}
