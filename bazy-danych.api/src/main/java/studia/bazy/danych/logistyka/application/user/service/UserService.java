package studia.bazy.danych.logistyka.application.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import studia.bazy.danych.logistyka.domain.user.form.LoginForm;
import studia.bazy.danych.logistyka.domain.user.form.RegisterForm;
import studia.bazy.danych.logistyka.infrastructure.user.repository.UserRepository;

import javax.validation.Valid;

import static studia.bazy.danych.logistyka.application.user.service.UserApi.USER_ROOT_PATH;

@RestController
@RequestMapping(USER_ROOT_PATH)
public class UserService implements UserApi{

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = USER_REGISTER, method = RequestMethod.POST)
    public void registerUser(@Valid RegisterForm registerForm) {

    }

    @RequestMapping(value = USER_LOGIN, method = RequestMethod.POST)
    public void loginUser(@Valid LoginForm loginForm) {

    }

}
