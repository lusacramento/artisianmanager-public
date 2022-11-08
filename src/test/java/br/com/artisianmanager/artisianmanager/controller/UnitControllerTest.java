package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.model.entity.UnitTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UnitControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UnitController unitController;

    UnitTest unitTest;

    Unit unit;
    @BeforeEach
    void setUp() {
        this.unitTest = new UnitTest();
    }
    @Test
    void Crud() throws Exception {
        save();
        findAll();
        findById();
        deleteById();
    }

    @Test
    void save()  throws Exception{
        setUp();
        this.unit = unitTest.setUnit();

        mockMvc.perform(post("/api/units")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(this.unit)))
                .andExpect(status().isCreated());
    }

    void findAll() throws Exception {
        mockMvc.perform(get("/api/units"))
                .andExpect(status().isOk());
    }

    void findById() throws Exception {
        this.unit = unitTest.setUnit();
        String id = this.unit.get_id();

        mockMvc.perform(get("/api/units/" + id))
                .andExpect(status().isOk());
    }

    void deleteById() throws Exception{
        this.unit = unitTest.setUnit();
        String id = this.unit.get_id();
        mockMvc.perform(delete("/api/units/" + id).contentType("application/json")
                        .accept("application/json"))
                .andExpect(status().isNoContent());
    }
}