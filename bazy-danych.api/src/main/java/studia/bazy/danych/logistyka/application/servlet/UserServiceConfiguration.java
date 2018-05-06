package studia.bazy.danych.logistyka.application.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.application.user.service.UserApi;

@Configuration
@ComponentScan(basePackageClasses = UserApi.class)
public class UserServiceConfiguration {
}
