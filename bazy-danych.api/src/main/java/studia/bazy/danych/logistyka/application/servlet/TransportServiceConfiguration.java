package studia.bazy.danych.logistyka.application.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.application.transport.service.TransportApi;

@Configuration
@ComponentScan(basePackageClasses = TransportApi.class)
public class TransportServiceConfiguration {
}
