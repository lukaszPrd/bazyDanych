package studia.bazy.danych.logistyka.application.root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.infrastructure.user.repository.UserRepository;
import studia.bazy.danych.logistyka.infrastructure.user.repository.UserRepositoryImpl;

@Configuration
@ComponentScan(basePackageClasses = UserRepository.class)
public class UserRepositoryConfiguration {

    @Bean
    public UserRepository userRepository(){
        return new UserRepositoryImpl();
    }

}
