package br.com.artisianmanager.artisianmanager.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Unit {
    @Id
    private String _id;
    private String name;
    private String symbol;

    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    // private String registerDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")).toString();
    // private String updateDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")).toString();

    // Getters and Setters
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
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public LocalDateTime getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
       // this.updateDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")).toString();
        this.updateDate = updateDate;
    }
}
