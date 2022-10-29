package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.repository.UnitRepository;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public <Optional> java.util.Optional<Unit> findById(String id) {
        return unitRepository.findById(id);
    }

    @Override
    public Boolean existsById(String id) {
        return this.unitRepository.existsById(id);
    }


    @Override
    public Unit save(Unit unit) {
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
