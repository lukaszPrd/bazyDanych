package studia.bazy.danych.logistyka.domain.transport.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderForm {
    @NotEmpty
    private DeliveryType deliveryType;
    @NotEmpty
    private AddressForm addressFormFrom;
    @NotEmpty
    private AddressForm addressFormTo;
    private String comments;
    @NotEmpty
    private List<PackageForm> packageForms;
}
