package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import br.com.artisianmanager.artisianmanager.repository.RawMaterialRepository;
import br.com.artisianmanager.artisianmanager.service.RawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RawMaterialServiceImpl implements RawMaterialService {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Override
    public List<RawMaterial> findAll() {

        return rawMaterialRepository.findAll();
    }

    @Override
    public Optional<RawMaterial> findById(String _id){

        return rawMaterialRepository.findById(_id);
    }

    @Override
    public RawMaterial save(RawMaterial rawmaterial) {
        return rawMaterialRepository.save(rawmaterial);
    }

    @Override
    public boolean deleteById(String _id) {
        try {
            rawMaterialRepository.deleteById(_id);
            return true;
        } catch (Exception e){
            new IllegalArgumentException("Não encontrado!");
            return false;
        }
    }

    @Override
    public boolean existsById(String id) {
        return this.rawMaterialRepository.existsById(id);
    }
}
