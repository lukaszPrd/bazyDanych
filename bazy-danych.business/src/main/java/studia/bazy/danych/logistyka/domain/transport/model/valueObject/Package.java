package studia.bazy.danych.logistyka.domain.transport.model.valueObject;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Package {
    private Integer height;
    private Integer width;
    private Integer length;
    private Integer weight;
}
