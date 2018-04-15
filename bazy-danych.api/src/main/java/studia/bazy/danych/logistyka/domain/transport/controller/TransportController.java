package studia.bazy.danych.logistyka.domain.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(ORDER_CREATE_PATH)
    public void createNewOrder(OrderForm orderForm) {

    }

    @RequestMapping(CHANGE_STATUS_PATH)
    public void changeConsignmentStatus(StatusChangeForm statusChangeForm) {

    }

}
