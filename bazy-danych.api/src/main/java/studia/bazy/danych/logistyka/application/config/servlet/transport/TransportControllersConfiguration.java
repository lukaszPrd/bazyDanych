package studia.bazy.danych.logistyka.application.config.servlet.transport;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.domain.transport.controller.TransportApi;

@Configuration
@ComponentScan(basePackageClasses = TransportApi.class)
public class TransportControllersConfiguration {
}
