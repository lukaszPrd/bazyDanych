package studia.bazy.danych.logistyka.domain.transport.model.valueObject;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class Package {
    @NotEmpty
    private Integer height;
    @NotEmpty
    private Integer width;
    @NotEmpty
    private Integer length;
    @NotEmpty
    private Integer weight;
}
