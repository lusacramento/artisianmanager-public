package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;

@Document
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recipe {
    @Id
    @EqualsAndHashCode.Include
    private String _id;

    @NotBlank
    private String name;

    private String instructions;

    @NotBlank
    private int portions;

    @NotBlank
    private String unit;

    @NotBlank
    private int time;

    private String registerDate;

    private String updateDate;
    @NotBlank
    private ArrayList<Ingredient> ingredients;
}
