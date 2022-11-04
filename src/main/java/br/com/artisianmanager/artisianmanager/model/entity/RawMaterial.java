package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RawMaterial {

        @Id
        @EqualsAndHashCode.Include
        private String _id;
        private String name;
        private String description;
        private String unit;
        private String registerDate;
        private String updateDate;
}