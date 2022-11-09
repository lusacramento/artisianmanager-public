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

    Recipe recipe;

    @BeforeEach
    void setUp() {
        recipeTest = new RecipeTest();
    }

    @Test
    void Crud() throws Exception {
        save();
        findAll();
        findById();
        deleteById();
    }

    void save() throws Exception {
        setUp();
        this.recipe = recipeTest.setRecipe();

        mockMvc.perform(post("/api/recipes")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(recipe)))
                .andExpect(status().isCreated());
    }

    void findAll() throws Exception {
        mockMvc.perform(get("/api/recipes"))
        .andExpect(status().isOk());
    }

    void findById() throws Exception {
        this.recipe = recipeTest.setRecipe();
        String id = this.recipe.get_id();
        mockMvc.perform(get("/api/recipes/" + id))
                .andExpect(status().isOk());
    }


    void deleteById() throws Exception {
        this.recipe = recipeTest.setRecipe();
        String id = recipe.get_id();
        mockMvc.perform(delete("/api/recipes/" + id)
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isNoContent());
    }
}