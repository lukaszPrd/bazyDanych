package studia.bazy.danych.logistyka.infrastructure.transport.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import studia.bazy.danych.logistyka.application.converter.DozerConverterImpl;
import studia.bazy.danych.logistyka.domain.transport.model.criteria.ConsignmentSearchCriteria;
import studia.bazy.danych.logistyka.domain.transport.model.entity.Consignment;
import studia.bazy.danych.logistyka.domain.transport.model.entity.ConsignmentEntity;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.DeliveryType;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

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

    @Override
    public List<Consignment> findBySearchCriteria(ConsignmentSearchCriteria criteria) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ConsignmentEntity> qCriteria = builder.createQuery(ConsignmentEntity.class);
        Root<ConsignmentEntity> root = qCriteria.from(ConsignmentEntity.class);
        if(criteria.hasFilteringCriteria()){
            qCriteria = addFilteringCriteria(criteria, qCriteria, builder, root);
        }
        if(criteria.hasSortingCriteria()){
            qCriteria.orderBy(obtainOrderingList(root, criteria.getSortingCriteria(), builder));
        }
        Query query = entityManager.createQuery(qCriteria);
        if(criteria.hasPagination()){
            query.setFirstResult(criteria.getPageNumber()).setMaxResults(criteria.getPageSize());
        }
        return converter.convert(query.getResultList(), Consignment.class);
    }

    private List<Order> obtainOrderingList(Root root, Map<String, Object> sortingCriteria, CriteriaBuilder builder){
        List<Order> sorting = newArrayList();
        for (Map.Entry<String, Object> entry:sortingCriteria.entrySet()) {
            if(entry.getValue().toString().toUpperCase().equals("ASC")){
                sorting.add(builder.asc(root.get(entry.getKey())));
            }else{
                sorting.add(builder.desc(root.get(entry.getKey())));
            }

        }
        return sorting;
    }

    private CriteriaQuery addFilteringCriteria(ConsignmentSearchCriteria criteria, CriteriaQuery qCriteria, CriteriaBuilder builder, Root root){
        if(criteria.hasFilteringCriteria()){
            for (Map.Entry<String, Object> entry:criteria.getFilteringCriteria().entrySet()) {
                if(Arrays.stream(DeliveryType.values()).anyMatch(t -> t.toString().equals(entry.getValue().toString()))) {
                    qCriteria.where(builder.equal(root.get(entry.getKey()), DeliveryType.valueOf(entry.getValue().toString())));
                }
            }
        }
        return qCriteria;
    }

}
