package com.galmv_.customer;

import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerRepository;
import com.galmv_.customer.factories.MakeCustomer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CustomerApplication.class
)
public class UnitTestsPreConfig {

    @Autowired
    protected CustomerRepository customerRepository;

    protected Customer customer = MakeCustomer.execute();

    protected final UUID invalidId = UUID.randomUUID();

    @BeforeEach
    public void before(){
        this.customerRepository.save(customer);
    }

    @AfterEach
    public void after(){
        this.customerRepository.deleteAll();
    }
}
