package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.domain.exception.NotFoundException;
import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @GetMapping
     public List<Unit> findAll(){
        return this.unitService.findAll();
    }

    @GetMapping(value = "/{_id}")
    public ResponseEntity<Unit> findById(@PathVariable("_id")String _id){
         return this.unitService.findById(_id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Unit save(@RequestBody @Valid Unit unit){
        return this.unitService.save(unit);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-all/{token}")
    public List<Unit> saveMany(@PathVariable String token, @Valid @RequestBody List<Unit> units) {
        String validPwd = "123";
        if(token.equals(validPwd)){
            return this.unitService.saveMany(units);
        }

        return null;
    }

    @PutMapping("/{_id}")
    public ResponseEntity<Unit> alter(@Valid @PathVariable String _id, @RequestBody @Valid Unit unit){
        if(!unitService.existsById(_id)) {
            throw new NotFoundException("Dado não encontrado");
        }

        unit.set_id(_id);
        unitService.alter(unit);
        return ResponseEntity.ok(unit);
    }

    @DeleteMapping("/{_id}")
    public ResponseEntity<Void> deleteById(@PathVariable String _id){
        if(!unitService.existsById(_id))
            throw new NotFoundException("Unidade não encontrada! Contacte o suporte.");

        unitService.deleteById(_id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-all/{token}")
    public ResponseEntity<Void> deleteAll(@PathVariable String token){
        String validPwd = "123";
        if(token.equals(validPwd)) {
            this.unitService.deleteAll();
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.badRequest().build();
        }
    }
}
