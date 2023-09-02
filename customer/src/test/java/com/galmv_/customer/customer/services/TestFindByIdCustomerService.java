package com.galmv_.customer.customer.services;

import com.galmv_.customer.UnitTestsPreConfig;
import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import com.galmv_.customer.domain.customer.services.FindByIdCustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class TestFindByIdCustomerService extends UnitTestsPreConfig {

    @Autowired
    private FindByIdCustomerService findByIdCustomerService;

    @Test
    @DisplayName("should to be able to find a customer by Id")
    public void testSuccessFindById(){
        Customer customers = this.findByIdCustomerService.execute(customer.getId());

        assertNotNull(customers.getId());
    }

    @Test
    @DisplayName("should not to be able to find a customer by Id if this one don't exists")
    public void testFailFindById(){
        assertThrows(CustomerNotFoundException.class, () -> this.findByIdCustomerService.execute(invalidId));
    }
}
