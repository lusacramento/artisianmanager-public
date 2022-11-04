package br.com.artisianmanager.artisianmanager.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

    Recipe recipe;

    @BeforeEach
    void setUp() {
        this.recipe = new Recipe();
    }

    @Test
    void Setters(){
        setRecipe();
    }

    public Recipe setRecipe(){
        setUp();
        this.recipe.setName("Recipe 1");
        this.recipe.setInstructions("Instructions 1");
        this.recipe.setPortions(3);
        this.recipe.setUnit("m");
        return this.recipe;
    }
}