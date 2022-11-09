package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 1, max = 20)
    private String name;

    @NotBlank
    @Size(min = 1)
    private String instructions;

    @NotNull
    @Min(1)
    private int portions;

    @NotBlank
    @Size(min = 1, max = 6)
    private String unit;

    @NotNull
    @Min(1)
    private int time;

    private String registerDate;

    private String updateDate;

    @NotNull
    @Valid
    private ArrayList<Ingredient> ingredients;
}
