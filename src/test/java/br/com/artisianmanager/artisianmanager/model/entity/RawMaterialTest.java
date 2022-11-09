package br.com.artisianmanager.artisianmanager.model.entity;

import br.com.artisianmanager.artisianmanager.service.UtilsService;
import br.com.artisianmanager.artisianmanager.service.impl.UtilsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RawMaterialTest {

    RawMaterial rawMaterial;

    @Autowired
    UtilsService utilsService;

    @BeforeEach
    void setUp() {
        rawMaterial = new RawMaterial();
        utilsService = new UtilsServiceImpl();
    }
    @Test
    void rawMaterialSetters(){
        setRawMaterial();
    }

    @Test
    void getRawMaterial(){
        setRawMaterial();

        String date = utilsService.getNewDate();
        this.rawMaterial.setRegisterDate(date);
        this.rawMaterial.setUpdateDate(date);

        Assertions.assertEquals("Ovo", this.rawMaterial.getName(), "Material1");
        Assertions.assertEquals("Ovo orgânico grande", this.rawMaterial.getDescription());
        Assertions.assertEquals("und", this.rawMaterial.getUnit());
        Assertions.assertEquals(date, this.rawMaterial.getRegisterDate());
        Assertions.assertEquals(date, this.rawMaterial.getUpdateDate());
    }


    public RawMaterial setRawMaterial(){
        setUp();
        this.rawMaterial.set_id("222");
        this.rawMaterial.setName("Ovo");
        this.rawMaterial.setDescription("Ovo orgânico grande");
        this.rawMaterial.setUnit("und");
        return this.rawMaterial;

    }
}