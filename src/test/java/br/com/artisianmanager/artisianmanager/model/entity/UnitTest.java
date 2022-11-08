package br.com.artisianmanager.artisianmanager.model.entity;

import br.com.artisianmanager.artisianmanager.service.UtilsService;
import br.com.artisianmanager.artisianmanager.service.impl.UtilsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;

public class UnitTest {
    public Unit unit = new Unit();

    @Autowired
    private UtilsService utilsService;

    @BeforeEach
    void setUp() {
        unit = new Unit();
        this.utilsService = new UtilsServiceImpl();
    }
    @Test
    void unitSetters(){
    Unit unit = setUnit();
    };

    @Test
    void getUnit(){
        setUnit();

        String date = utilsService.getNewDate();
        this.unit.setRegisterDate(date);
        this.unit.setUpdateDate(date);

        Assertions.assertEquals("111", this.unit.get_id());
        Assertions.assertEquals("Quilo", this.unit.getName());
        Assertions.assertEquals("Kg", this.unit.getSymbol());
        Assertions.assertEquals(date, this.unit.getRegisterDate());
        Assertions.assertEquals(date, this.unit.getUpdateDate());
    }

    public Unit setUnit(){
        this.unit.set_id("111");
        this.unit.setName("Quilo");
        this.unit.setSymbol("Kg");
        return this.unit;
    }
}