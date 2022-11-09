package br.com.artisianmanager.artisianmanager.model.entity;

import br.com.artisianmanager.artisianmanager.service.UtilsService;
import br.com.artisianmanager.artisianmanager.service.impl.UtilsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {

    Recipe recipe;

    @Autowired
    private UtilsService utilsService;

    @BeforeEach
    void setUp() {
        this.recipe = new Recipe();
        this.utilsService = new UtilsServiceImpl();
    }

    @Test
    void recipeSetters(){
        setRecipe();
    }

    @Test
    void getrecipe(){
        setRecipe();

        String date = utilsService.getNewDate();
        this.recipe.setRegisterDate(date);
        this.recipe.setUpdateDate(date);

        Assertions.assertEquals("333", recipe.get_id());
        Assertions.assertEquals("Bolo", recipe.getName());
        Assertions.assertEquals("Misturar tudo", recipe.getInstructions());
        Assertions.assertEquals(5, recipe.getPortions());
        Assertions.assertEquals("und", recipe.getUnit());
        Assertions.assertEquals(4, recipe.getTime());

        ArrayList<Ingredient> ingredients = new ArrayList<>(recipe.getIngredients());

        Assertions.assertEquals("401", ingredients.get(0).get_id());
        Assertions.assertEquals("Ovo", ingredients.get(0).getName());
        Assertions.assertEquals(3, ingredients.get(0).getQuantity());
        Assertions.assertEquals("und", ingredients.get(0).getUnit());

        Assertions.assertEquals("402", ingredients.get(1).get_id());
        Assertions.assertEquals("Farinha", ingredients.get(1).getName());
        Assertions.assertEquals(300, ingredients.get(1).getQuantity());
        Assertions.assertEquals("g", ingredients.get(1).getUnit());

        Assertions.assertEquals(date, this.recipe.getRegisterDate());
        Assertions.assertEquals(date, this.recipe.getUpdateDate());

    }

    public Recipe setRecipe(){
        setUp();

        this.recipe.set_id("333");
        this.recipe.setName("Bolo");
        this.recipe.setInstructions("Misturar tudo");
        this.recipe.setPortions(5);
        this.recipe.setUnit("und");
        this.recipe.setTime(4);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.set_id("401");
        ingredient1.setName("Ovo");
        ingredient1.setQuantity(3);
        ingredient1.setUnit("und");

        Ingredient ingredient2 = new Ingredient();
        ingredient2.set_id("402");
        ingredient2.setName("Farinha");
        ingredient2.setQuantity(300);
        ingredient2.setUnit("g");

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        this.recipe.setIngredients(ingredients);
        return this.recipe;
    }
}