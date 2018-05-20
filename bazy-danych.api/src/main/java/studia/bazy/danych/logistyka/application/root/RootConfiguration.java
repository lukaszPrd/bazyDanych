package studia.bazy.danych.logistyka.application.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.application.converter.BaseCustomConverter;

@Configuration
@ComponentScan(basePackageClasses = {RootConfiguration.class, BaseCustomConverter.class})
public class RootConfiguration {

}
