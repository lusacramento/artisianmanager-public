package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RawMaterialController {
    @Autowired
    private RawMaterialService rawMaterialService;

    @GetMapping("api/raw-materials")
    public List<RawMaterial> findAll(){
        return this.rawMaterialService.findAll();
    }

    @PostMapping("api/raw-materials/insert")
    public RawMaterial save(@RequestBody RawMaterial rawMaterial){
        return this.rawMaterialService.save(rawMaterial);
    }

    @DeleteMapping("api/raw-materials/delete")
    public boolean deleteById(String _id){
        return this.rawMaterialService.deleteById(_id);
    }
}

