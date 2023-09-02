package com.galmv_.customer.domain.customer.services;

import com.galmv_.customer.constants.Errors;
import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerRepository;
import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FindByIdCustomerService {

    private final CustomerRepository repository;

    public Customer execute(UUID customerId){
        Optional<Customer> optionalCustomer = this.repository.findById(customerId);

        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException(Errors.CUSTOMER_NOT_FOUND);
        }

        return optionalCustomer.get();
    }
}
