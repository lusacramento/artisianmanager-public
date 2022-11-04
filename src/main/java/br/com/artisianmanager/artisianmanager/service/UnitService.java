package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UnitService {
    List<Unit> findAll();

    Optional<Unit> findById(String id);

    Boolean existsById(String id);

    Unit save(Unit unit);

    boolean deleteById(String _id);
}
