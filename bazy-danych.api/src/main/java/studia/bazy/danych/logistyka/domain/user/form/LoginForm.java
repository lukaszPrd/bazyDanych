package studia.bazy.danych.logistyka.domain.user.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class LoginForm {
    @NotEmpty
    private String login;
    @NotEmpty
    private String password;
}
