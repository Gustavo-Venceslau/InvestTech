package com.galmv_.customer.domain.customer.controllers;

import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerDTO;
import com.galmv_.customer.domain.customer.exceptions.CustomerAlreadyExistsException;
import com.galmv_.customer.domain.customer.services.RegisterCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class RegisterCustomerController {

    private final RegisterCustomerService registerCustomerService;

    @PostMapping
    public ResponseEntity<Customer> handle(@RequestBody CustomerDTO newCustomerData){
        try {
            Customer newCustomer = registerCustomerService.execute(newCustomerData);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCustomer.getId()).toUri();

            return ResponseEntity.created(uri).body(newCustomer);
        }catch (CustomerAlreadyExistsException e){
            log.info("Exception: " + e);

            return ResponseEntity.badRequest().build();
        }
    }
}
