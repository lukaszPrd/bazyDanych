package studia.bazy.danych.logistyka.domain.transport.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.DeliveryType;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consignment_id")
    private Long id;
    private DeliveryType deliveryType;
    private String comments;
    private ConsignmentStatus status;
    @OneToOne(mappedBy = "consignmentEntity", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private AddressEntity addressFrom;
    @OneToOne(mappedBy = "consignmentEntity", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private AddressEntity addressTo;
    @OneToMany(mappedBy="consignmentEntity", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<PackageEntity> packages;

}