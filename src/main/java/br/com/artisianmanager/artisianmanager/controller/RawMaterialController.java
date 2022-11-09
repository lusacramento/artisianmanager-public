package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.domain.exception.NotFoundException;
import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.service.RawMaterialService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/raw-materials")
public class RawMaterialController {
    @Autowired
    private RawMaterialService rawMaterialService;

    @Autowired
    private UtilsService utilsService;

    @GetMapping
    public List<RawMaterial> findAll(){
        return this.rawMaterialService.findAll();
    }

    @GetMapping(value = "/{_id}")
    public ResponseEntity<RawMaterial> findById(@PathVariable("_id")String _id){
        return this.rawMaterialService.findById(_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RawMaterial save(@RequestBody @Valid RawMaterial rawMaterial){
            return this.rawMaterialService.save(rawMaterial);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-all/{token}")
    public List<RawMaterial> saveMany(@PathVariable String token, @Valid @RequestBody List<RawMaterial> rawMaterials){
        String validPwd = "123";
        if(token.equals(validPwd)){
            return this.rawMaterialService.saveMany(rawMaterials);
        }
        return null;
    }

    @PutMapping("/{_id}")
    public ResponseEntity<RawMaterial> alter(@Valid @PathVariable String _id, @RequestBody @Valid RawMaterial rawMaterial){
        if(!rawMaterialService.existsById(_id)){
            throw new NotFoundException("Dado não encontrado");
        }

        rawMaterial.set_id(_id);
        rawMaterialService.alter(rawMaterial);
        return ResponseEntity.ok(rawMaterial);
    }

    @DeleteMapping("/{_id}")
    public ResponseEntity<Void> deleteById(@PathVariable String _id){
        if(!rawMaterialService.existsById(_id)){
            throw new NotFoundException("Matéria prima não encontrada! Contacte o suporte");
        }

        rawMaterialService.deleteById(_id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete-all/{token}")
    public ResponseEntity<Void> deleteAll(@PathVariable String token){
        String validPwd = "123";
        if(token.equals(validPwd)){
            this.rawMaterialService.deleteAll();
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

