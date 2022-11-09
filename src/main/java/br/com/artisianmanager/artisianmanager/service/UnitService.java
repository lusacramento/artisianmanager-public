package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UnitService {
    List<Unit> findAll();

    Optional<Unit> findById(String id);

    Unit findByName(String name, Unit unit);

    boolean existsById(String id);

    Unit save(Unit unit);

    List<Unit> saveMany(List<Unit> units);

    Unit alter(Unit unit);

    void deleteById(String _id);

    void deleteAll();
}
