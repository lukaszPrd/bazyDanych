package studia.bazy.danych.logistyka.domain.transport.model.valueObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Package {
    private Integer height;
    private Integer width;
    private Integer length;
    private Integer weight;
}
