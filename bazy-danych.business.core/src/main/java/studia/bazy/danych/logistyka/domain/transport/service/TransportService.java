package studia.bazy.danych.logistyka.domain.transport.service;

import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;

public interface TransportService {
    ConsignmentStatus getConsigmentStatus(Long id);
}
