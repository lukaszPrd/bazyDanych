package studia.bazy.danych.logistyka.infrastructure.user.service;

import org.springframework.stereotype.Service;
import studia.bazy.danych.logistyka.domain.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void registerUser() {
        System.out.print("register"); //TODO implement me
    }

    @Override
    public void loginUser() {
        System.out.print("login"); //TODO implement me
    }

}
