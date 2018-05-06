package studia.bazy.danych.logistyka.domain.transport.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.Address;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.DeliveryType;

import java.util.List;

@Data
@NoArgsConstructor
public class Consignment {
    private Long id;
    private DeliveryType deliveryType;
    private Address addressFrom;
    private Address addressTo;
    private String comments;
    private List<Package> packages;
}
