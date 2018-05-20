package studia.bazy.danych.logistyka.infrastructure.transport.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import studia.bazy.danych.logistyka.application.converter.DozerConverterImpl;
import studia.bazy.danych.logistyka.domain.transport.model.entity.Consignment;
import studia.bazy.danych.logistyka.domain.transport.model.entity.ConsignmentEntity;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ConsignmentRepositoryImpl implements ConsignmentRepository {

    private EntityManager entityManager;
    private DozerConverterImpl converter;

    @Autowired
    public ConsignmentRepositoryImpl(EntityManager entityManager, DozerConverterImpl converter) {
        this.entityManager = entityManager;
        this.converter = converter;
    }

    @Override
    @Transactional
    public void save(Consignment consignment) {
        entityManager.persist(converter.convert(consignment, ConsignmentEntity.class));
        entityManager.flush();
    }

    @Override
    public List<Consignment> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM ConsignmentEntity e");
        return converter.convert((List<ConsignmentEntity>) query.getResultList(), Consignment.class);
    }

    @Override
    public Consignment findById(Long id) {
        return converter.convert(entityManager.find(ConsignmentEntity.class, id), Consignment.class);
    }

    @Override
    public void editConsignmentStatus(Long id, ConsignmentStatus status) {
        ConsignmentEntity con = entityManager.find(ConsignmentEntity.class, id);
        if (con != null) {
            con.setStatus(status);
        }
    }
}
