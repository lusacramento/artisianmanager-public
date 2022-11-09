package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {
    List<Recipe> findAll();

    Optional<Recipe> findById(String _id);

    Recipe findByName(String name, Recipe recipe);

    boolean existsById(String id);

    Recipe save(Recipe recipe);

    List<Recipe> saveMany(List<Recipe> recipes);

    Recipe alter(Recipe recipe);

    void deleteById(String _id);

    void deleteAll();
}