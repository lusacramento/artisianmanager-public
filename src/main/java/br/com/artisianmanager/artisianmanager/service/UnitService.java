package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UnitService {
    List<Unit> findAll();

    Unit save(Unit unit);

    boolean deleteById(String _id);
}
