package br.com.artisianmanager.artisianmanager.repository;

import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
