package studia.bazy.danych.logistyka.application.converter;

import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.stereotype.Component;
import studia.bazy.danych.logistyka.domain.transport.form.PackageForm;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.Package;

@Component
public class OrderFormMapping extends BeanMappingBuilder {

    @Override
    protected void configure() {
        mapping(PackageForm.class, Package.class);
    }

}