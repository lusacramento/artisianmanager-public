package br.com.artisianmanager.artisianmanager.repository;

import br.com.artisianmanager.artisianmanager.model.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UnitRepository extends MongoRepository<Unit, String> {

    Unit queryFirstByName(String name, Unit unit);
}
