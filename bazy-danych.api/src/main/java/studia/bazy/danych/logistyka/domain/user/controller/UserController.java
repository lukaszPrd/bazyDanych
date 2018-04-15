package studia.bazy.danych.logistyka.domain.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import studia.bazy.danych.logistyka.domain.user.model.entity.LoginForm;
import studia.bazy.danych.logistyka.domain.user.model.entity.RegisterForm;
import studia.bazy.danych.logistyka.domain.user.service.UserService;

import javax.validation.Valid;

import static studia.bazy.danych.logistyka.domain.user.controller.UserApi.USER_ROOT_PATH;

@RestController
@RequestMapping(USER_ROOT_PATH)
public class UserController implements UserApi{

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = USER_REGISTER, method = RequestMethod.POST)
    public void registerUser(@Valid RegisterForm registerForm) {
        userService.registerUser();
    }

    @RequestMapping(value = USER_LOGIN, method = RequestMethod.POST)
    public void loginUser(@Valid LoginForm loginForm) {
        userService.loginUser();
    }

}
