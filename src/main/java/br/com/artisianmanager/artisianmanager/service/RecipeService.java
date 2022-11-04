package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RecipeService {
    public List<Recipe> findAll();
    Recipe save(Recipe recipe);

    public boolean deleteById(String _id);

    Optional<Recipe> findById(String id);
