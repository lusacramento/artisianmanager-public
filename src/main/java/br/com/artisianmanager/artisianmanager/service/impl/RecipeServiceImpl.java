package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.domain.exception.BadRequestException;
import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import br.com.artisianmanager.artisianmanager.repository.RecipeRepository;
import br.com.artisianmanager.artisianmanager.service.RecipeService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    UtilsService utilsService;


    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(String _id) {
        return recipeRepository.findById(_id);
    }

    @Override
    public Recipe findByName(String name, Recipe recipe) {
        return recipeRepository.queryFirstByName(name, recipe);
    }

    @Override
    public boolean existsById(String id) {
        return this.recipeRepository.existsById(id);
    }

    @Override
    @Transactional
    public Recipe save(Recipe recipe) {
        if (findByName(recipe.getName(), recipe) != null) {
            throw new BadRequestException("Já existe receita com o nome: " + recipe.getName().toUpperCase() + ".");
        } else {
            recipe.setRegisterDate(utilsService.getNewDate());
            recipe.setUpdateDate(utilsService.getNewDate());
        }
        return recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> saveMany(List<Recipe> recipes) {
        recipes.forEach(recipe -> {
            if(findByName(recipe.getName(), recipe) != null){
                throw new BadRequestException("Já existe receita com o nome: " + recipe.getName().toUpperCase() + ".");
            } else {
                recipe.setRegisterDate(utilsService.getNewDate());
                recipe.setUpdateDate(utilsService.getNewDate());
            }
        });
        return recipeRepository.saveAll(recipes);
    }

    @Override
    public Recipe alter(Recipe recipe) {
        recipe.setRegisterDate(recipeRepository.findById(recipe.get_id()).get().getRegisterDate());
        recipe.setUpdateDate(utilsService.getNewDate());

        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(String _id) {
            recipeRepository.deleteById(_id);
    }

    @Override
    public void deleteAll() {
        recipeRepository.deleteAll();
    }


}
