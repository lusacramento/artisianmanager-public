package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import br.com.artisianmanager.artisianmanager.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("api/recipes")
    public List<Recipe> findAll(){
        return  this.recipeService.findAll();
    }

    @PostMapping("api/recipes/insert")
    public Recipe save(@RequestBody Recipe recipe){
        return this.recipeService.save(recipe);
    }

    @DeleteMapping("api/recipes/delete")
    public boolean deleteById(String _id){
        return this.recipeService.deleteById(_id);
    }

}
