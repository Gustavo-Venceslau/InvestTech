package com.galmv_.customer.domain.customer.controllers;

import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import com.galmv_.customer.domain.customer.services.FindByIdCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/customer/{id}")
@RequiredArgsConstructor
@Slf4j
public class FindByIdCustomerController {

    private final FindByIdCustomerService findByIdCustomerService;

    @GetMapping
    public ResponseEntity<Customer> handle(@PathVariable("id") UUID customerId){
        try {
            Customer customer = findByIdCustomerService.execute(customerId);

            return ResponseEntity.ok().body(customer);
        }catch (CustomerNotFoundException e){
            log.info("Exception: " + e);

            return ResponseEntity.notFound().build();
        }
    }
}
