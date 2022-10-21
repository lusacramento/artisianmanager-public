package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;
     @GetMapping("api/units")
     public List<Unit> findAll(){
        return this.unitService.findAll();
    }

    @PostMapping("api/units/insert")
    public Unit save(@RequestBody Unit unit){
         return this.unitService.save(unit);
    }

    @DeleteMapping("api/units/delete")
    public boolean deleteById(String _id){
         return this.unitService.deleteById(_id);
    }
}
