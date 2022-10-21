package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import br.com.artisianmanager.artisianmanager.repository.RecipeRepository;
import br.com.artisianmanager.artisianmanager.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public boolean deleteById(String _id) {
        try {
            recipeRepository.deleteById(_id);
            return true;
        } catch (Exception e){
            new IllegalArgumentException("Não encontrado!");
            return false;
        }
    }

}
