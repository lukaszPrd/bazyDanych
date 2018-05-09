package studia.bazy.danych.logistyka.infrastructure.transport.repository;

import studia.bazy.danych.logistyka.domain.transport.model.entity.Consignment;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;

import java.util.List;

public interface ConsignmentRepository {
    void save(Consignment consignment);
    List<Consignment> findAll();
    Consignment findById(Long id);
    void editConsignmentStatus(Long id, ConsignmentStatus status);
}
