package com.galmv_.customer.factories;

import com.galmv_.customer.domain.customer.Customer;

public class MakeCustomer {

    public static Customer execute(){
        return Customer.builder()
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@mail.com")
                .password("password")
                .build();
    }
}
