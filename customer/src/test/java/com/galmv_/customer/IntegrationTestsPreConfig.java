package com.galmv_.customer;

import com.galmv_.customer.domain.customer.Customer;
import com.galmv_.customer.domain.customer.CustomerRepository;
import com.galmv_.customer.factories.customer.MakeCustomer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = CustomerApplication.class
)
@AutoConfigureMockMvc
public class IntegrationTestsPreConfig {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected CustomerRepository customerRepository;

    protected final UUID invalidId = UUID.randomUUID();

    protected Customer customer = MakeCustomer.execute();

    @BeforeEach
    public void before(){
        this.customerRepository.save(customer);
    }

    @AfterEach
    public void after(){
        this.customerRepository.deleteAll();
    }
}
