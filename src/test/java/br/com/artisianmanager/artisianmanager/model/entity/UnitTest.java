package br.com.artisianmanager.artisianmanager.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UnitTest {
    @Autowired
    public Unit unit = new Unit();
    public LocalDateTime dateTime = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        unit = new Unit();
    }

    @Test
    void unitSetters(){
    Unit unit = setUnit();
    };

    @Test
    void getUnit(){
        setUnit();
        Assertions.assertEquals("111", this.unit.get_id());
        Assertions.assertEquals("Quilo", this.unit.getName());
        Assertions.assertEquals("Kg", this.unit.getSymbol());
//        Assertions.assertEquals(dateTime, this.unit.getRegisterDate());
//        Assertions.assertEquals(dateTime, this.unit.getUpdateDate());
    }

    public Unit setUnit(){
        this.unit.set_id("111");
        this.unit.setName("Quilo");
        this.unit.setSymbol("Kg");
//        this.unit.setRegisterDate();
//        this.unit.setUpdateDate();
        return this.unit;
    }
}