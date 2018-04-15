package studia.bazy.danych.logistyka.domain.transport.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.Address;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.DeliveryType;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.Package;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderForm {
    @NotEmpty
    private Long id;
    @NotEmpty
    private DeliveryType deliveryType;
    @NotEmpty
    private Address addressFrom;
    @NotEmpty
    private Address addressTo;
    private String comments;
    @NotEmpty
    private List<Package> packages;
}
