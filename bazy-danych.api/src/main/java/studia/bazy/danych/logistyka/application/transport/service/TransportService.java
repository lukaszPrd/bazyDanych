package studia.bazy.danych.logistyka.application.transport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studia.bazy.danych.logistyka.application.converter.DozerConverterImpl;
import studia.bazy.danych.logistyka.domain.transport.form.OrderForm;
import studia.bazy.danych.logistyka.domain.transport.form.StatusChangeForm;
import studia.bazy.danych.logistyka.domain.transport.model.entity.Consignment;
import studia.bazy.danych.logistyka.infrastructure.transport.repository.ConsignmentRepository;

import static studia.bazy.danych.logistyka.application.transport.service.TransportApi.TRANSPORT_ROOT_PATH;

@RestController
@RequestMapping(TRANSPORT_ROOT_PATH)
public class TransportService implements TransportApi {

    private ConsignmentRepository consignmentRepository;
    private DozerConverterImpl converter;

    @Autowired
    public TransportService(ConsignmentRepository consignmentRepository, DozerConverterImpl dozerConverter) {
        this.consignmentRepository = consignmentRepository;
        this.converter = dozerConverter;
    }

    @RequestMapping(value = ORDER_CREATE_PATH, method = RequestMethod.POST)
    public void createNewOrder(@RequestBody OrderForm orderForm) {
        System.out.print(orderForm);
        consignmentRepository.save(converter.convert(orderForm, Consignment.class));
    }

    @RequestMapping(value = GET_STATUS_PATH+"/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> obtainConsignmentStatus(@PathVariable Long id) {
        return new ResponseEntity<String>(consignmentRepository.findById(id).getDeliveryType().name(), HttpStatus.OK);
    }

    @RequestMapping(value = CHANGE_STATUS_PATH, method = RequestMethod.POST)
    public void changeConsignmentStatus(StatusChangeForm statusChangeForm) {

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void findall() {
        System.out.print(consignmentRepository.findAll());
    }

}
