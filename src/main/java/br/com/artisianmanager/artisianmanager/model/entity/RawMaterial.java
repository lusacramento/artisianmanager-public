package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Document
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RawMaterial {

        @Id
        @EqualsAndHashCode.Include
        private String _id;

        @NotBlank
        @Size(min = 1, max = 20)
        private String name;

        @NotBlank
        @Size(min = 1, max = 5000)
        private String description;

        @NotBlank
        @Size(min = 1, max = 6)
        private String unit;


        private String registerDate;

        private String updateDate;
}