package studia.bazy.danych.logistyka.domain.transport.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressForm {
    private String name;
    private String surname;
    private String phone;
    private String houseNumber;
    private String street;
    private String postCode;
    private String city;
    private String country;
}
