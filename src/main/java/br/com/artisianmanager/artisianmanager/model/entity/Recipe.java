package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
@Getter
@Setter
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
}
