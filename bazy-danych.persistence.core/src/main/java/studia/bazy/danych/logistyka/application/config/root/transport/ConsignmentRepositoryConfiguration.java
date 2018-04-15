package studia.bazy.danych.logistyka.application.config.root.transport;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.infrastructure.transport.repository.ConsignmentRepositoryImpl;

@Configuration
@ComponentScan(basePackageClasses = ConsignmentRepositoryImpl.class)
public class ConsignmentRepositoryConfiguration {
}
