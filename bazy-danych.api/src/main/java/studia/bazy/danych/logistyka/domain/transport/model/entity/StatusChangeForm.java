package studia.bazy.danych.logistyka.domain.transport.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.ConsignmentStatus;

@Data
@NoArgsConstructor
public class StatusChangeForm {
    @NotEmpty
    private Long id;
    @NotEmpty
    private ConsignmentStatus status;
}
