package studia.bazy.danych.logistyka.domain.common.form;

import lombok.Data;
import studia.bazy.danych.logistyka.domain.common.model.valueObject.Paginator;

import java.util.Map;

@Data
public class SearchForm {
    private Paginator paginator;
    private Map<String, Object> filteringCriteria;
    private Map<String, Object> sortingCriteria;
}