package com.galmv_.customer.customer.controllers;

import com.galmv_.customer.IntegrationTestsPreConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class TestDeleteCustomerController extends IntegrationTestsPreConfig {

    @Test
    @DisplayName("should to be able to delete a customer in /customer/{id}")
    public void testSuccessDelete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/{id}", customer.getId()))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("should to be able to delete a customer in /customer/{id}")
    public void testFailDelete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer/{id}", invalidId))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }
}
