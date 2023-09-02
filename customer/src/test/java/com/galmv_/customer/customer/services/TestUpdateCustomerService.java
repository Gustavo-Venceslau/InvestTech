package com.galmv_.customer.customer.services;

import com.galmv_.customer.UnitTestsPreConfig;
import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerDTO;
import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import com.galmv_.customer.domain.customer.services.UpdateCustomerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class TestUpdateCustomerService extends UnitTestsPreConfig {

    @Autowired
    private UpdateCustomerService updateCustomerService;

    @Test
    @DisplayName("should to be able to update a customer")
    public void testSuccessUpdate(){
        CustomerDTO customerNewData = new CustomerDTO("John", "Doe", "johndoe01@mail.com", "123");

        Customer updatedCustomer = this.updateCustomerService.execute(customer.getId(), customerNewData);

        assertEquals("johndoe01@mail.com", updatedCustomer.getEmail());
    }

    @Test
    @DisplayName("should not to be able to update a customer if this one don't exists")
    public void testFailUpdate(){
        CustomerDTO customerNewData = new CustomerDTO("John", "Doe", "johndoe01@mail.com", "123");

        assertThrows(CustomerNotFoundException.class, () -> this.updateCustomerService.execute(invalidId, customerNewData));
    }
}
