package studia.bazy.danych.logistyka.application.user.service;

import studia.bazy.danych.logistyka.domain.user.form.LoginForm;
import studia.bazy.danych.logistyka.domain.user.form.RegisterForm;

public interface UserApi {
    String USER_ROOT_PATH = "/user";
    String USER_REGISTER = "/register";
    String USER_LOGIN = "/login";
    void registerUser(RegisterForm registerForm);
    void loginUser(LoginForm loginForm);
}
