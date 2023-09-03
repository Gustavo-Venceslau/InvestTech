package com.galmv_.customer.domain.customer.controllers;

import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerDTO;
import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import com.galmv_.customer.domain.customer.services.UpdateCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customer/{id}")
@RequiredArgsConstructor
@Slf4j
public class UpdateCustomerController {

    private final UpdateCustomerService updateCustomerService;

    @PutMapping
    public ResponseEntity<Customer> handle(@PathVariable("id") UUID customerId, @RequestBody CustomerDTO customerNewData){
        try {
            Customer updatedCustomer = updateCustomerService.execute(customerId, customerNewData);

            return ResponseEntity.ok().body(updatedCustomer);
        } catch (CustomerNotFoundException e){
            log.info("Exception: " + e);

            return ResponseEntity.notFound().build();
        }
    }
}
