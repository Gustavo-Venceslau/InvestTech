package com.galmv_.customer.domain.customer.exceptions;

import java.io.Serial;

public class CustomerNotFoundException extends RuntimeException{

    @Serial
    private final static long serialVersionUID = 1L;

    public CustomerNotFoundException(String message){
        super(message);
    }
}
