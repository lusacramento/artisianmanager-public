package br.com.artisianmanager.artisianmanager.model.entity;

import br.com.artisianmanager.artisianmanager.service.UtilsService;
import br.com.artisianmanager.artisianmanager.service.impl.UtilsServiceImpl;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class RawMaterialTest {

    @Autowired
    RawMaterial rawMaterial;

    @Autowired
    UtilsService utilsService;

    @BeforeEach
    void setUp() {
        utilsService = new UtilsServiceImpl();
        rawMaterial = new RawMaterial();
    }

    @Test
    void Getters(){
        Setters();
        Assertions.assertEquals("Material1", this.rawMaterial.getName(), "Material1");
        Assertions.assertEquals("description material 1", this.rawMaterial.getDescription());
        Assertions.assertEquals("Kg", this.rawMaterial.getUnit());
    }

    @Test
    void Setters(){
        setRawMaterial();
    }

    public RawMaterial setRawMaterial(){
        setUp();
        this.rawMaterial.setName("Material1");
        this.rawMaterial.setDescription("description material 1");
        this.rawMaterial.setUnit("Kg");
        this.rawMaterial.setRegisterDate(this.utilsService.getDate());
        this.rawMaterial.setUpdateDate(this.utilsService.getDate());
        return this.rawMaterial;

    }
}