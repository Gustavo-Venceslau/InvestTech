package com.galmv_.customer.domain.customer.services;

import com.galmv_.customer.constants.Errors;
import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerDTO;
import com.galmv_.customer.domain.customer.CustomerRepository;
import com.galmv_.customer.domain.customer.exceptions.CustomerAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService {

    public final CustomerRepository repository;

    public Customer execute(CustomerDTO newCustomerData){
        Optional<Customer> existingCustomer = this.repository.findByEmail(newCustomerData.email());

        if (existingCustomer.isPresent()) throw new CustomerAlreadyExistsException(Errors.CUSTOMER_ALREADY_EXISTS);

        Customer newCustomer = Customer.builder()
                .firstName(newCustomerData.firstName())
                .lastName(newCustomerData.lastName())
                .email(newCustomerData.email())
                .password(newCustomerData.password())
                .build();

        return this.repository.save(newCustomer);
    }
}
