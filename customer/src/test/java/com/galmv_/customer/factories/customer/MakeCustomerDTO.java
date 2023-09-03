package com.galmv_.customer.factories.customer;

import com.galmv_.customer.domain.customer.CustomerDTO;

public class MakeCustomerDTO {

    public static CustomerDTO createDTO(){
        return new CustomerDTO("Gustavo", "Almeida", "gustavo@mail.com", "1234");
    }
}
