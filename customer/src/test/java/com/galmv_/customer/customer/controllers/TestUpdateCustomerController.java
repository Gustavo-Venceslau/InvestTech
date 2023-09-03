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

public class TestUpdateCustomerController extends IntegrationTestsPreConfig {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("should to be able to update a customer in /customer/{id}")
    public void testSuccessUpdateCustomer() throws Exception{
        CustomerDTO customerNewData = MakeCustomerDTO.createDTO();

        String customerNewDataJson = objectMapper.writeValueAsString(customerNewData);

        mockMvc.perform(MockMvcRequestBuilders.put("/customer/{id}", customer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(customerNewDataJson)
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value(customerNewData.email()))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("should not to be able to update a customer in /customer/{id} if this one don't exists")
    public void testFailUpdateCustomer() throws Exception{
        CustomerDTO customerNewData = MakeCustomerDTO.createDTO();

        String customerNewDataJson = objectMapper.writeValueAsString(customerNewData);

        mockMvc.perform(MockMvcRequestBuilders.put("/customer/{id}", invalidId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(customerNewDataJson)
                )
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }
}
