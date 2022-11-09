package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Ingredient {
    @Id
    @EqualsAndHashCode.Include
    private String _id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @NotNull
    @Min(1)
    private int quantity;

    @NotBlank
    @Size(min = 1, max = 6)
    private String unit;
}
