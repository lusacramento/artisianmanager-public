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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    RawMaterial rawMaterial;

    @BeforeEach
    void setUp() {
        rawMaterialTest = new RawMaterialTest();
    }

    @Test
    void Crud() throws Exception {
        save();
        findAll();
        findById();
        deleteById();
    }
    void save()  throws Exception{
        setUp();
        this.rawMaterial = rawMaterialTest.setRawMaterial();

        mockMvc.perform(post("/api/raw-materials")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(this.rawMaterial)))
                .andExpect(status().isCreated());
    }

    void findAll() throws Exception {
        mockMvc.perform(get("/api/raw-materials"))
                .andExpect(status().isOk());
    }

    void findById() throws Exception {
        this.rawMaterial = rawMaterialTest.setRawMaterial();
        String id = this.rawMaterial.get_id();

        mockMvc.perform(get("/api/raw-materials/" + id))
                .andExpect(status().isOk());
    }

    void deleteById() throws Exception{
        this.rawMaterial = rawMaterialTest.setRawMaterial();
        String id = this.rawMaterial.get_id();
        mockMvc.perform(delete("/api/raw-materials/" + id).contentType("application/json")
                        .accept("application/json"))
                .andExpect(status().isNoContent());
    }

}