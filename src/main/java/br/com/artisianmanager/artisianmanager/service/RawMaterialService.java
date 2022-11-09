package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RawMaterialService {

    List<RawMaterial> findAll();

    Optional<RawMaterial> findById(String _id);

    RawMaterial findByName(String name, RawMaterial rawMaterial);

    boolean existsById(String id);

    RawMaterial save(RawMaterial rawMaterial);

    List<RawMaterial>saveMany(List<RawMaterial> rawMaterials);

    RawMaterial alter(RawMaterial rawMaterial);

    void deleteById(String _id);

    void deleteAll();
}
