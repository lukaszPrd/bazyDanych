package studia.bazy.danych.logistyka.application.transport.service;

import org.springframework.http.ResponseEntity;
import studia.bazy.danych.logistyka.domain.common.form.SearchForm;
import studia.bazy.danych.logistyka.domain.transport.form.OrderForm;
import studia.bazy.danych.logistyka.domain.transport.form.StatusChangeForm;

import java.util.List;

public interface TransportApi {
    String TRANSPORT_ROOT_PATH = "/transport";
    String CHANGE_STATUS_PATH = "/status/change";
    String GET_STATUS_PATH = "/status/get";
    String ORDER_CREATE_PATH = "/order/create";
    String SEARCH_PATH = "/search";
    void createNewOrder(OrderForm orderForm);
    void changeConsignmentStatus(StatusChangeForm statusChangeForm);
    ResponseEntity<String> obtainConsignmentStatus(Long id);
    List<OrderForm> searchConsignment(SearchForm searchForm);
    List<OrderForm> findall();
}
