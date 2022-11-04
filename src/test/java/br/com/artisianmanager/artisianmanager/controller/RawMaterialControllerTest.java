package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.model.entity.RawMaterialTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class RawMaterialControllerTest {
    @Autowired
    RawMaterialController rawMaterialController;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    RawMaterialTest rawMaterialTest;

    @BeforeEach
    void setUp() {
        rawMaterialTest = new RawMaterialTest();
    }

    @Test
    void findAll() throws Exception{
        mockMvc.perform(get("/api/raw-materials"))
                .andExpect(status().isOk());

    }

    @Test
    void findById() throws Exception{
        String id = "111";
        mockMvc.perform(get("/api/raw-materials/" + id))
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {
        setUp();
        RawMaterial rawMaterial = rawMaterialTest.setRawMaterial();

        mockMvc.perform(post("/api/raw-materials")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(rawMaterial))).andExpect(status().isOk());
    }

    @Test
    void deleteById() {
    }
}