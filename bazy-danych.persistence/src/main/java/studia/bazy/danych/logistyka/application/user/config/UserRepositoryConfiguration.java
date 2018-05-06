package studia.bazy.danych.logistyka.application.user.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.infrastructure.user.repository.UserRepository;

@Configuration
@ComponentScan(basePackageClasses = UserRepository.class)
public class UserRepositoryConfiguration {
}
