package studia.bazy.danych.logistyka.domain.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import studia.bazy.danych.logistyka.domain.transport.model.entity.OrderForm;
import studia.bazy.danych.logistyka.domain.transport.model.entity.StatusChangeForm;
import studia.bazy.danych.logistyka.domain.transport.service.TransportService;

import static studia.bazy.danych.logistyka.domain.transport.controller.TransportApi.TRANSPORT_ROOT_PATH;

@RestController
@RequestMapping(TRANSPORT_ROOT_PATH)
public class TransportController implements TransportApi {

    private TransportService transportService;

    @Autowired
    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @RequestMapping(value = ORDER_CREATE_PATH, method = RequestMethod.POST)
    public void createNewOrder(OrderForm orderForm) {

    }

    @RequestMapping(value = CHANGE_STATUS_PATH, method = RequestMethod.POST)
    public void changeConsignmentStatus(StatusChangeForm statusChangeForm) {

    }

    @RequestMapping(value = GET_STATUS_PATH+"/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> obtainConsignmentStatus(@PathVariable Long id) {
        return new ResponseEntity<String>(transportService.getConsigmentStatus(id).name(), HttpStatus.OK);
    }

}
