package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private UtilsService utilsService;

    @GetMapping("/api/units")
     public List<Unit> findAll(){
        return this.unitService.findAll();
    }

    @RequestMapping(value = "/api/units/{_id}", method = RequestMethod.GET)
    public Optional<Unit> findById(@PathVariable("_id")String _id){
         return this.unitService.findById(_id);
    }

    @PostMapping("api/units")
    public Unit save(@RequestBody @Valid Unit unit){
         // Validations
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

    @DeleteMapping("/api/units/{_id}")
    @ResponseBody
    public boolean deleteById(@PathVariable String _id){
         return this.unitService.deleteById(_id);
    }
}
