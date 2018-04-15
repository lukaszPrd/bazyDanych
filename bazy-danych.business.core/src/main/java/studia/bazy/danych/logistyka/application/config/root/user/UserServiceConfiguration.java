package studia.bazy.danych.logistyka.application.config.root.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.infrastructure.user.service.UserServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = UserServiceImpl.class)
public class UserServiceConfiguration {
}
