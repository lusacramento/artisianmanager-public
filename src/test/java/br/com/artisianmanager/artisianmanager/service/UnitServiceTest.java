package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.model.entity.UnitTest;
import br.com.artisianmanager.artisianmanager.repository.UnitRepository;
import br.com.artisianmanager.artisianmanager.service.impl.UnitServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
class UnitServiceTest {

    @TestConfiguration
    static class UnitServiceTestConfiguration{

        @Bean
        public UnitService unitService(){
            return new UnitServiceImpl();
        }
    }
    @Autowired
    public UnitService unitService;

    @Autowired
    public UnitTest unitTest;

    @Autowired
    public Unit unit;


    @Test
    void findAll() {
    }

    @Test
    void save() {
        setUp();
        this.unit = unitTest.setUnit();
        this.unitService.save(unit);
   }

    @Test
    void deleteById() {
    }
    @Before
    void setUp() {
        List<Unit> list = new ArrayList<Unit>();
        this.unitService = new UnitServiceImpl();
        this.unitTest = new UnitTest();



    }
}