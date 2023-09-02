package com.galmv_.customer.domain.customer.services;

import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteCustomerService {

    private final CustomerRepository repository;
    private final FindByIdCustomerService findByIdCustomerService;

    public void execute(UUID customerId){
        Customer customerToDelete = findByIdCustomerService.execute(customerId);

        this.repository.delete(customerToDelete);
    }
}
