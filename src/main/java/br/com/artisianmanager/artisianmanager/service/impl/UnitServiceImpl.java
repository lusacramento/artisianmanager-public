package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.domain.exception.BusinessException;
import br.com.artisianmanager.artisianmanager.domain.exception.EntityNotFoundException;
import br.com.artisianmanager.artisianmanager.domain.exception.EntityNotModifiedException;
import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.repository.UnitRepository;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public Optional<Unit> findById(String id) {
        return unitRepository.findById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return unitRepository.queryFirstByName(name);
    }


    @Override
    public Boolean existsById(String id) {
        return this.unitRepository.existsById(id);
    }


    @Override
    public Unit save(Unit unit) {

        // Verify if exist for name before to persist.
        boolean existByName = unitRepository.queryFirstByName(unit.getName());
        if(!existByName)
            throw new EntityNotModifiedException("Já existe unidade com o nome " + unit.getName() + ".");

        return unitRepository.save(unit);
    }

    @Override
    public boolean deleteById(String _id) {
        try {
            unitRepository.deleteById(_id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
