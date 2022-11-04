package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.RawMaterial;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RawMaterialService {
    public List<RawMaterial> findAll();
    public Optional<RawMaterial> findById(String _id);
    public RawMaterial save(RawMaterial rawmaterial);
    public boolean deleteById(String _id);

    boolean existsById(String id);
}
