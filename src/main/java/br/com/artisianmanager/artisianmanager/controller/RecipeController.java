package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.Recipe;
import br.com.artisianmanager.artisianmanager.service.RecipeService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UtilsService utilsService;

    @GetMapping("api/recipes")
    public List<Recipe> findAll(){
        return  this.recipeService.findAll();
    }

    @RequestMapping(value = "/api/recipes/{_id}", method = RequestMethod.GET)
    public Optional<Recipe> findById(@PathVariable("_id") String _id){
        return this.recipeService.findById(_id);

    }

    @PostMapping("api/recipes")
    public Recipe save(@RequestBody Recipe recipe){

        // Validations
        if (this.utilsService.verifyNullField(recipe.getName())
                || this.utilsService.verifyNullField(recipe.getInstructions())
                || this.utilsService.verifyNullField(recipe.getUnit()) ||
                (recipe.getPortions() <= 0)
                || (recipe.getTime() <= 0)
                        ){
            return null;
        } else {
            //verify if exists id
            boolean isExistRecipe = false;
            if(recipe.get_id() != null){
                isExistRecipe = this.recipeService.existsById(recipe.get_id());
            }

            // case exist the id, don't set new date in the register date
            if(isExistRecipe){
                recipe.setRegisterDate(this.recipeService.findById(recipe.get_id()).orElse(null).getRegisterDate());
            } else {
                recipe.setRegisterDate(this.utilsService.getDate());
            }

            recipe.setUpdateDate(this.utilsService.getDate());

            return this.recipeService.save(recipe);
        }
    }

    @DeleteMapping("api/recipes/{_id}")
    public boolean deleteById(@PathVariable String _id){
        if(this.recipeService.existsById(_id))
        return this.recipeService.deleteById(_id);
        else return false;
    }

}
