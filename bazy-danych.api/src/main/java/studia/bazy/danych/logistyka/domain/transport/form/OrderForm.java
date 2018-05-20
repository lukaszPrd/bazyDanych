package studia.bazy.danych.logistyka.domain.transport.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import studia.bazy.danych.logistyka.domain.transport.model.valueObject.DeliveryType;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderForm {
    @NotEmpty
    private DeliveryType deliveryType;
    @NotEmpty
    private AddressForm addressFrom;
    @NotEmpty
    private AddressForm addressTo;
    private String comments;
    @NotEmpty
    private List<PackageForm> packages;
}
