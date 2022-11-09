package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.domain.exception.NotFoundException;
import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import br.com.artisianmanager.artisianmanager.service.RecipeService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> findAll(){
        return  this.recipeService.findAll();
    }

    @GetMapping(value = "/{_id}")
    public ResponseEntity<Recipe> findById(@PathVariable("_id") String _id){
        return this.recipeService.findById(_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Recipe save(@RequestBody @Valid Recipe recipe) {
        return this.recipeService.save(recipe);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-all/{token}")
    public List<Recipe> saveMany(@PathVariable String token, @Valid @RequestBody List<Recipe> recipes){
        String validPwd = "123";
        if(token.equals(validPwd)){
            return this.recipeService.saveMany(recipes);
        }

        return null;
    }

    @PutMapping("/{_id}")
    public ResponseEntity<Recipe> alter(@Valid @PathVariable String _id, @RequestBody @Valid Recipe recipe){
        if(!recipeService.existsById(_id)){
            throw new NotFoundException("Dado não encontrado");
        }

        recipe.set_id(_id);
        recipeService.alter(recipe);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{_id}")
    public ResponseEntity<Void> deleteById(@PathVariable String _id){
        if(!this.recipeService.existsById(_id)){
            throw new NotFoundException("Receita não encontrada!");
        }

        recipeService.deleteById(_id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete-all/{token}")
    public ResponseEntity<Void> deleteAll(@PathVariable String token) {
        String validPwd = "123";
        if(token.equals(validPwd)){
            this.recipeService.deleteAll();
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}