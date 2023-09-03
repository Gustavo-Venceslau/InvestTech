package com.galmv_.customer.customer.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.galmv_.customer.IntegrationTestsPreConfig;
import com.galmv_.customer.domain.customer.CustomerDTO;
import com.galmv_.customer.factories.customer.MakeCustomerDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class TestRegisterCustomerController extends IntegrationTestsPreConfig {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("should to be able to register a new customer in /customer")
    public void testSuccessRegisterCustomerController() throws Exception{
        CustomerDTO newCustomerData = MakeCustomerDTO.createDTO();

        String newCustomerDataMapped = objectMapper.writeValueAsString(newCustomerData);

        mockMvc.perform(MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(newCustomerDataMapped)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("should not to be able to register a new customer in /customer if this one exists")
    public void testFailRegisterCustomerController() throws Exception{
        CustomerDTO newCustomerData = new CustomerDTO("John", "Doe", "johndoe@mail.com", "123");

        String newCustomerDataMapped = objectMapper.writeValueAsString(newCustomerData);

        mockMvc.perform(MockMvcRequestBuilders.post("/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(newCustomerDataMapped)
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andDo(MockMvcResultHandlers.print());
    }
}
