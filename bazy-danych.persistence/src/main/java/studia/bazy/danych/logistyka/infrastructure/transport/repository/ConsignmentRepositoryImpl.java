package studia.bazy.danych.logistyka.infrastructure.transport.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import studia.bazy.danych.logistyka.domain.transport.model.entity.Consignment;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ConsignmentRepositoryImpl implements ConsignmentRepository {

    private EntityManager entityManager;

    @Autowired
    public ConsignmentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Consignment consignment) {
        entityManager.persist(consignment);
        entityManager.flush();
    }

    @Override
    public List<Consignment> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM Consignment e");
        return (List<Consignment>) query.getResultList();
    }

    @Override
    public Consignment findById(Long id) {
        return entityManager.find(Consignment.class, id);
    }

    @Override
    public void editConsignmentStatus(Long id, ConsignmentStatus status) {
        Consignment con = entityManager.find(Consignment.class, id);
        if (con != null) {
            con.setStatus(status);
        }
    }
}
