package studia.bazy.danych.logistyka.application.config.servlet.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.domain.user.controller.UserApi;

@Configuration
@ComponentScan(basePackageClasses = UserApi.class)
public class UserControllersConfiguration {
}
