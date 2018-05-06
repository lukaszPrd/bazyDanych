package studia.bazy.danych.logistyka.application.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import studia.bazy.danych.logistyka.application.MainConfiguration;

@Configuration
@ComponentScan(basePackageClasses = ServletConfiguration.class)
@Import(MainConfiguration.class)
public class ServletConfiguration {
}
