package studia.bazy.danych.logistyka.infrastructure.transport.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import studia.bazy.danych.logistyka.domain.transport.model.entity.Consignment;

import java.util.List;

@Repository
public class ConsignmentRepositoryImpl implements ConsignmentRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(Consignment consignment) {

    }

    @Override
    public List<Consignment> findAll() {
        return null;
    }

    @Override
    public Consignment findById(Long id) {
        return null;
    }
}
