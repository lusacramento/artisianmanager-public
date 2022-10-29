package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private UtilsService utilsService;

     @GetMapping("api/units")
     public List<Unit> findAll(){
        return this.unitService.findAll();
    }

    @PostMapping("api/units/insert")
    public Unit save(@RequestBody Unit unit){
         if(this.utilsService.verifyNullField(unit.getName()) || this.utilsService.verifyNullField(unit.getSymbol())){
             return null;
         }
         else {

             // verify if exists id
             boolean isExistUnit = false;
             if (unit.get_id() != null) {
                 isExistUnit = this.unitService.existsById(unit.get_id());
             }

             // Case exist the id, don't set new date in the register date
             if (isExistUnit) {
                 unit.setRegisterDate(this.unitService.findById(unit.get_id()).orElse(null).getRegisterDate());

             } else {
                 unit.setRegisterDate(this.utilsService.getDate());
             }

             unit.setUpdateDate(this.utilsService.getDate());

             return this.unitService.save(unit);
         }
    }

    @DeleteMapping("api/units/delete")
    public boolean deleteById(String _id){
         return this.unitService.deleteById(_id);
    }
}
