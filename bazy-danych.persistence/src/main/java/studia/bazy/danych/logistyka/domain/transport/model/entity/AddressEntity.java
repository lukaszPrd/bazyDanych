package studia.bazy.danych.logistyka.domain.transport.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String houseNumber;
    private String street;
    private String postCode;
    private String city;
    private String country;
    @OneToOne
    @JoinColumn(name = "consignment_id")
    private ConsignmentEntity consignmentEntity;
}
