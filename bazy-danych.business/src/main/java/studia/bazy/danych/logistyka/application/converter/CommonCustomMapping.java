package studia.bazy.danych.logistyka.application.converter;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOptions;
import org.springframework.stereotype.Component;

@Component
public class CommonCustomMapping extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(Long.class, String.class, TypeMappingOptions.oneWay());
    }

}