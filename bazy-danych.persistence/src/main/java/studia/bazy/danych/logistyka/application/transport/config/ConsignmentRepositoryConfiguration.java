package studia.bazy.danych.logistyka.application.transport.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.infrastructure.transport.repository.ConsignmentRepository;

@Configuration
@ComponentScan(basePackageClasses = ConsignmentRepository.class)
public class ConsignmentRepositoryConfiguration {
}
