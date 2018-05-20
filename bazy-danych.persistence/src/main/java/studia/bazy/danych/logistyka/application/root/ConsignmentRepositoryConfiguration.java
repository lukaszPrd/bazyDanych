package studia.bazy.danych.logistyka.application.root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.application.converter.DozerConverterImpl;
import studia.bazy.danych.logistyka.infrastructure.transport.repository.ConsignmentRepository;
import studia.bazy.danych.logistyka.infrastructure.transport.repository.ConsignmentRepositoryImpl;

import javax.persistence.EntityManager;

@Configuration
@ComponentScan(basePackageClasses = ConsignmentRepository.class)
public class ConsignmentRepositoryConfiguration {

    @Bean
    public ConsignmentRepository consignmentRepository(EntityManager entityManager, DozerConverterImpl converter){
        return new ConsignmentRepositoryImpl(entityManager, converter);
    }

}
