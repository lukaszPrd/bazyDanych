package studia.bazy.danych.logistyka.domain.transport.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.DeliveryType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private DeliveryType deliveryType;
    private String comments;
    private ConsignmentStatus status;
    //TODO start here
//    @OneToMany(mappedBy="orderItems", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
//    private List<ItemEntity> items;
//    @OneToMany(mappedBy="orderPayments", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
//    private List<PaymentEntity> payments;
//    private String receiptId;
//    private int edited;
//    private BigDecimal returnValue;
//    @Enumerated(value = EnumType.STRING)
//    private PaymentEntity.PAYMENT_METHODS returnMethod;
//
//    private Address addressFrom;
//    private Address addressTo;
//    private List<Package> packages;


}