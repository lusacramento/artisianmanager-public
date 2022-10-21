package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {
    public List<Recipe> findAll();
    Recipe save(Recipe recipe);

    public boolean deleteById(String _id);
}
