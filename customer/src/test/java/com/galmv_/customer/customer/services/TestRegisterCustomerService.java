package com.galmv_.customer.customer.services;

import com.galmv_.customer.UnitTestsPreConfig;
import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerDTO;
import com.galmv_.customer.domain.customer.exceptions.CustomerAlreadyExistsException;
import com.galmv_.customer.domain.customer.services.RegisterCustomerService;
import com.galmv_.customer.factories.customer.MakeCustomerDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class TestRegisterCustomerService extends UnitTestsPreConfig {

    @Autowired
    private RegisterCustomerService registerCustomerService;

    @Test
    @DisplayName("should to be able to register a new customer")
    public void testSuccessRegisterCustomerService(){
        CustomerDTO customerDTO = MakeCustomerDTO.createDTO();

        Customer newCustomer = registerCustomerService.execute(customerDTO);

        assertNotNull(newCustomer.getId());
    }

    @Test
    @DisplayName("should not to be able to register a new customer if customer already exists")
    public void testFailRegisterCustomerService(){
        CustomerDTO customerDTO = new CustomerDTO("John", "Doe", "johndoe@mail.com", "123");

        assertThrows(CustomerAlreadyExistsException.class, () -> this.registerCustomerService.execute(customerDTO));
    }

}
