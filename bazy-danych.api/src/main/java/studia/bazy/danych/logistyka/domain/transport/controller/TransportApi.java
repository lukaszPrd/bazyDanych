package studia.bazy.danych.logistyka.domain.transport.controller;

import org.springframework.http.ResponseEntity;
import studia.bazy.danych.logistyka.domain.transport.model.entity.OrderForm;
import studia.bazy.danych.logistyka.domain.transport.model.entity.StatusChangeForm;

public interface TransportApi {
    String TRANSPORT_ROOT_PATH = "/transport";
    String CHANGE_STATUS_PATH = "/status/change";
    String GET_STATUS_PATH = "/status/get";
    String ORDER_CREATE_PATH = "/order/create";
    void createNewOrder(OrderForm orderForm);
    void changeConsignmentStatus(StatusChangeForm statusChangeForm);
    ResponseEntity<String> obtainConsignmentStatus(Long id);
}
