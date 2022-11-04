package br.com.artisianmanager.artisianmanager.controller;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.service.RawMaterialService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RawMaterialController {
    @Autowired
    private RawMaterialService rawMaterialService;

    @Autowired
    private UtilsService utilsService;

    @GetMapping("api/raw-materials")
    public List<RawMaterial> findAll(){
        return this.rawMaterialService.findAll();
    }

    @RequestMapping(value = "/api/raw-materials/{_id}", method = RequestMethod.GET)
    public Optional<RawMaterial> findById(@PathVariable("_id")String _id){
        return this.rawMaterialService.findById(_id);
    }

    @RequestMapping(value = "/api/raw-materials", method = RequestMethod.POST)
    public RawMaterial save(@RequestBody RawMaterial rawMaterial){
        //Validations
        if(
                this.utilsService.verifyNullField(rawMaterial.getName()) ||
                this.utilsService.verifyNullField(rawMaterial.getDescription()) ||
                this.utilsService.verifyNullField(rawMaterial.getUnit())
        ){
            return null;
        } else {
            // verify if exists id
            boolean isExistRawMaterial = false;
            if(rawMaterial.get_id() != null) {
                isExistRawMaterial = this.rawMaterialService.existsById(rawMaterial.get_id());
            }

            // Case exist the id, don't set new date in the register date
            if(isExistRawMaterial){
                rawMaterial.setRegisterDate(this.rawMaterialService.findById(rawMaterial.get_id()).orElse(null).getRegisterDate());
            } else {
                rawMaterial.setRegisterDate(this.utilsService.getDate());
            }

            rawMaterial.setUpdateDate(this.utilsService.getDate());
            return this.rawMaterialService.save(rawMaterial);
        }
    }

    @DeleteMapping("api/raw-materials/{_id}")
    @ResponseBody
    public boolean deleteById(@PathVariable String _id){
        return this.rawMaterialService.deleteById(_id);
    }
}

