package br.com.artisianmanager.artisianmanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class UnitControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api/units"))
                .andExpect(status().isOk());
    }


    @Test
    void save()  throws Exception{
        setUp();
        Unit unity = unit.setUnit();

        mockMvc.perform(post("/api/units")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(unity)))
                .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        String id = "111";
        mockMvc.perform(get("/api/units/" + id))
                .andExpect(status().isOk());
    }

    @Test
    void deleteById() {
    }
}