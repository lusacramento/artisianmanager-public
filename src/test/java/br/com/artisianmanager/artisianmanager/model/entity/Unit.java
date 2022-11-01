package br.com.artisianmanager.artisianmanager.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
public class Unit {
    @Id
    private String _id;
    private String name;
    private String symbol;

    private String registerDate;
    private String updateDate;
}
