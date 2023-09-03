package com.galmv_.customer.domain.customer.controllers;

import com.galmv_.customer.domain.customer.exceptions.CustomerNotFoundException;
import com.galmv_.customer.domain.customer.services.DeleteCustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/customer/{id}")
@RequiredArgsConstructor
@Slf4j
public class DeleteCustomerController {

    private final DeleteCustomerService deleteCustomerService;

    @DeleteMapping
    public ResponseEntity<Void> handle(@PathVariable("id") UUID customerId){
        try {
            deleteCustomerService.execute(customerId);

            return ResponseEntity.noContent().build();
        } catch (CustomerNotFoundException e){
            log.info("Exception: " + e);

            return ResponseEntity.notFound().build();
        }
    }
}
