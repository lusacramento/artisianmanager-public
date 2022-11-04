package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import br.com.artisianmanager.artisianmanager.model.entity.RecipeTest;
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
class RecipeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    RecipeController recipeController;

    @Autowired
    ObjectMapper objectMapper;

    RecipeTest recipeTest;
    @BeforeEach
    void setUp() {
        recipeTest = new RecipeTest();
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/api/recipes"))
        .andExpect(status().isOk());
    }

    @Test
    void findById() throws Exception {
        String id = "634db0504963f301dee1bd6c";
        mockMvc.perform(get("/api/recipes/" + id))
                .andExpect(status().isOk());
    }
    @Test
    void save() throws Exception {
        setUp();
        Recipe recipe = recipeTest.setRecipe();
        mockMvc.perform(post("/api/recipes")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(recipe)))
                .andExpect(status().isOk());

    }

    @Test
    void deleteById() throws Exception {
        String id = "111";
        mockMvc.perform(delete("/api/recipes/" + id)
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk());
    }
}