package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Document
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RawMaterial {

        @Id
        @EqualsAndHashCode.Include
        private String _id;

        @NotBlank
        private String name;

        @NotBlank
        private String description;

        @NotBlank
        private String unit;


        private String registerDate;

        private String updateDate;
}