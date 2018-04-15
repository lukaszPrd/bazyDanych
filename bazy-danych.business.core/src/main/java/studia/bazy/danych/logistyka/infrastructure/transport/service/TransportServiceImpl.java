package studia.bazy.danych.logistyka.infrastructure.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;
import studia.bazy.danych.logistyka.domain.transport.repository.ConsignmentRepository;
import studia.bazy.danych.logistyka.domain.transport.service.TransportService;

@Service
public class TransportServiceImpl implements TransportService {

    private ConsignmentRepository consignmentRepository;

    @Autowired
    public TransportServiceImpl(ConsignmentRepository consignmentRepository) {
        this.consignmentRepository = consignmentRepository;
    }

    @Override
    public ConsignmentStatus getConsigmentStatus(Long id) {
        return ConsignmentStatus.DOSTARCZONA; //TODO implement me
    }
}
