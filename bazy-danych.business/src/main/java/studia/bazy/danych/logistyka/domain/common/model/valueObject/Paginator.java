package studia.bazy.danych.logistyka.domain.common.model.valueObject;

import lombok.Data;

@Data
public class Paginator {
    private Integer pageSize;
    private Integer pageNumber;
}