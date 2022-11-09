package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.domain.exception.BadRequestException;
import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.repository.RawMaterialRepository;
import br.com.artisianmanager.artisianmanager.service.RawMaterialService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialServiceImpl implements RawMaterialService {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Autowired
    UtilsService utilsService;

    @Override
    public List<RawMaterial> findAll() {
        return rawMaterialRepository.findAll();
    }

    @Override
    public Optional<RawMaterial> findById(String _id){
        return rawMaterialRepository.findById(_id);
    }

    @Override
    public RawMaterial findByName(String name, RawMaterial rawMaterial) {
        return rawMaterialRepository.queryFirstByName(name, rawMaterial);
    }

    @Override
    public boolean existsById(String _id) {
        return this.rawMaterialRepository.existsById(_id);
    }

    @Override
    @Transactional
    public RawMaterial save(RawMaterial rawMaterial) {
        if(findByName(rawMaterial.getName(), rawMaterial) !=null){
            throw new BadRequestException("Já existe matéria prima com o nome: " + rawMaterial.getName().toUpperCase() + ".");
        } else {
            rawMaterial.setRegisterDate(utilsService.getNewDate());
            rawMaterial.setUpdateDate(utilsService.getNewDate());
        }

        return rawMaterialRepository.save(rawMaterial);
    }

    @Override
    public List<RawMaterial> saveMany(List<RawMaterial> rawMaterials) {
        rawMaterials.forEach(rawMaterial -> {
            if(findByName(rawMaterial.getName(), rawMaterial) != null){
                throw new BadRequestException("Já existe matéria prima com o nome: " + rawMaterial.getName().toUpperCase() + ".");
            } else {
                rawMaterial.setRegisterDate(utilsService.getNewDate());
                rawMaterial.setUpdateDate(utilsService.getNewDate());
            }
        });
        return rawMaterialRepository.saveAll(rawMaterials);
    }

    @Override
    public RawMaterial alter(RawMaterial rawMaterial) {
        rawMaterial.setRegisterDate(rawMaterialRepository.findById(rawMaterial.get_id()).get().getRegisterDate());
        rawMaterial.setUpdateDate(utilsService.getNewDate());
        return rawMaterialRepository.save(rawMaterial);
    }

    @Override
    @Transactional
    public void deleteById(String _id) {
            rawMaterialRepository.deleteById(_id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        rawMaterialRepository.deleteAll();
    }
}
