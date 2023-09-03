package com.galmv_.customer.customer.controllers;

import com.galmv_.customer.IntegrationTestsPreConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class TestFindByIdController extends IntegrationTestsPreConfig {

    @Test
    @DisplayName("should to be able to find customer by id in /customer{id}")
    public void testSuccessFindByIdController() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/{id}", customer.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(customer.getId().toString()))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("should not to be able to find customer by id in /customer if this one don't exists")
    public void testFailFindByIdController() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/{id}", invalidId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.log());
    }
}
