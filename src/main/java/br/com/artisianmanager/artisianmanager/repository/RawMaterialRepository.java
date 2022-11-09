package br.com.artisianmanager.artisianmanager.repository;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;


@Service
public interface RawMaterialRepository extends MongoRepository<RawMaterial, String> {
    RawMaterial queryFirstByName(String name, RawMaterial rawMaterial);
}
