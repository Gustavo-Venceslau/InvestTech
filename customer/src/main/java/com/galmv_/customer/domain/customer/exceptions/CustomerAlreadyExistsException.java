package com.galmv_.customer.domain.customer.exceptions;

import java.io.Serial;

public class CustomerAlreadyExistsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CustomerAlreadyExistsException(String message){
        super(message);
    }
}
