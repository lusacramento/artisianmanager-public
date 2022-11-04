package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/units")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @Autowired
    private UtilsService utilsService;

    @GetMapping
     public List<Unit> findAll(){
        return this.unitService.findAll();
    }

    @GetMapping(value = "/{_id}")
    public ResponseEntity<Unit> findById(@PathVariable("_id")String _id){
         return this.unitService.findById(_id)
                 .map((ResponseEntity::ok))
                 .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Unit save(@RequestBody @Valid Unit unit){
          return this.unitService.save(unit);
    }

    @DeleteMapping("/{_id}")
    @ResponseBody
    public boolean deleteById(@PathVariable String _id){
         return this.unitService.deleteById(_id);
    }
}
