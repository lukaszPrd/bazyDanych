package studia.bazy.danych.logistyka.domain.transport.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer height;
    private Integer width;
    private Integer length;
    private Integer weight;
    @ManyToOne
    @JoinColumn(name="consignment_id")
    private ConsignmentEntity consignmentEntity;
}
