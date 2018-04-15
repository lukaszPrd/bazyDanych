package studia.bazy.danych.logistyka.domain.user.controller;

import studia.bazy.danych.logistyka.domain.user.model.entity.LoginForm;
import studia.bazy.danych.logistyka.domain.user.model.entity.RegisterForm;

public interface UserApi {
    String USER_ROOT_PATH = "/user";
    String USER_REGISTER = "/register";
    String USER_LOGIN = "/login";
    void registerUser(RegisterForm registerForm);
    void loginUser(LoginForm loginForm);
}
