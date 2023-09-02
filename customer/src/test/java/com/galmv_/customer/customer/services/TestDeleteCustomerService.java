package com.galmv_.customer.customer.services;

import com.galmv_.customer.UnitTestsPreConfig;
import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import com.galmv_.customer.domain.customer.services.DeleteCustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TestDeleteCustomerService extends UnitTestsPreConfig {

    @Autowired
    private DeleteCustomerService deleteCustomerService;

    @Test
    @DisplayName("should to be able to delete a customer")
    public void testSuccessDelete(){
        this.deleteCustomerService.execute(customer.getId());

        Optional<Customer> deletedCustomer = this.customerRepository.findById(customer.getId());

        assertFalse(deletedCustomer.isPresent());
    }

    @Test
    @DisplayName("should not to be able to delete a customer if this one don't exists")
    public void testFailDelete(){
        assertThrows(CustomerNotFoundException.class, () ->
                this.deleteCustomerService.execute(invalidId));
    }
}
