package studia.bazy.danych.logistyka.infrastructure.user.repository;

import org.springframework.security.core.userdetails.User;

public interface UserRepository {
    void save(User user);
}
