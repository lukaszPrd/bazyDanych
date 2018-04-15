package studia.bazy.danych.logistyka.application.config.root.transport;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.infrastructure.transport.service.TransportServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = TransportServiceImpl.class)
public class TransportServiceConfiguration {
}
