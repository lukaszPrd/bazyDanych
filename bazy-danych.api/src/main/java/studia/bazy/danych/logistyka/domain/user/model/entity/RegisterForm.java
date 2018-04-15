package studia.bazy.danych.logistyka.domain.user.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class RegisterForm {
    public static final String PASSWORD_REGEXP = "^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$";
    public static final int PASSWORD_LEN = 8;
    @NotEmpty
    private String login;
    @Size(min=PASSWORD_LEN)
    @Pattern(regexp = PASSWORD_REGEXP)
    @NotEmpty
    private String password;
    @Size(min=PASSWORD_LEN)
    @Pattern(regexp = PASSWORD_REGEXP)
    @NotEmpty
    private String confirmPassword;
    @AssertTrue
    public boolean passwordAreEquals(){
        return password.equals(confirmPassword);
    }
}
