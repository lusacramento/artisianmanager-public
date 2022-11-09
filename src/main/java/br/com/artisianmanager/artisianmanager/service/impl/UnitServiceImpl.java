package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.domain.exception.BadRequestException;
import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import br.com.artisianmanager.artisianmanager.repository.UnitRepository;
import br.com.artisianmanager.artisianmanager.service.UnitService;
import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private UtilsService utilsService;

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public Optional<Unit> findById(String id) {
        return unitRepository.findById(id);
    }

    @Override
    public Unit findByName(String name, Unit unit) {
        return unitRepository.queryFirstByName(name, unit);
    }


    @Override
    public boolean existsById(String _id) {
        return this.unitRepository.existsById(_id);
    }

    @Override
    @Transactional
    public Unit save(Unit unit) {

        // Verify if exist for name before to persist.
        if (findByName(unit.getName(),unit) != null) {
            throw new BadRequestException("Já existe unidade com o nome: " + unit.getName().toUpperCase() + ".");
        } else {
            unit.setRegisterDate(utilsService.getNewDate());
            unit.setUpdateDate(utilsService.getNewDate());
        }

            return unitRepository.save(unit);
    }

    @Override
    @Transactional
    public List<Unit> saveMany(List<Unit> units) {
        units.forEach(unit -> {
            if (findByName(unit.getName(),unit) != null) {
                throw new BadRequestException("Já existe unidade com o nome: " + unit.getName().toUpperCase() + ".");
            } else {
                unit.setRegisterDate(utilsService.getNewDate());
                unit.setUpdateDate(utilsService.getNewDate());
            }
        });

        return unitRepository.saveAll(units);
    }

    @Override
    public Unit alter(Unit unit) {

        unit.setRegisterDate(unitRepository.findById(unit.get_id()).get().getRegisterDate());
        unit.setUpdateDate(utilsService.getNewDate());

        return unitRepository.save(unit);
    }

    @Override
    @Transactional
    public void deleteById(String _id) {
            unitRepository.deleteById(_id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        unitRepository.deleteAll();
    }
}
