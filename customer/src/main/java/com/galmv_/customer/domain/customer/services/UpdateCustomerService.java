package com.galmv_.customer.domain.customer.services;

import com.galmv_.customer.constants.Errors;
import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerDTO;
import com.galmv_.customer.domain.customer.CustomerRepository;
import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateCustomerService {

    private final CustomerRepository repository;

    public Customer execute(UUID customerId, CustomerDTO newData){
        Optional<Customer> existingCustomer = this.repository.findById(customerId);

        if(existingCustomer.isEmpty()) throw new CustomerNotFoundException(Errors.CUSTOMER_NOT_FOUND);

        Customer customerToUpdate = existingCustomer.get();

        changeCustomerData(customerToUpdate, newData);

        return this.repository.save(customerToUpdate);
    }

    private void changeCustomerData(Customer customerToUpdate, CustomerDTO newData) {
        customerToUpdate.setFirstName(newData.firstName());
        customerToUpdate.setLastName(newData.lastName());
        customerToUpdate.setEmail(newData.email());
        customerToUpdate.setPassword(newData.password());
    }
}
