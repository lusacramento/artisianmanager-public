package br.com.artisianmanager.artisianmanager.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Recipe {
    @Id
    private String _id;
    private String name;
    private String instructions;
    private int portions;
    private String unit;

    private int time;
    private String registerDate;
    private String updateDate;
    private ArrayList<Ingredient> ingredients;

    // Getters ans Setters
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public int getPortions() {
        return portions;
    }
    public void setPortions(int portions) {
        this.portions = portions;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    public String getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
    public String getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }
}
