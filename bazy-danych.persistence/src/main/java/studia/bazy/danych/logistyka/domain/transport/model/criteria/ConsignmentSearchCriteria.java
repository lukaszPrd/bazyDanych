package studia.bazy.danych.logistyka.domain.transport.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Getter
@AllArgsConstructor
public class ConsignmentSearchCriteria {
    private Integer pageNumber;
    private Integer pageSize;
    private Map<String, Object> sortingCriteria;
    private Map<String, Object> filteringCriteria;

    public boolean hasPagination(){ return pageNumber!=null && pageSize != null; }
    public boolean hasSortingCriteria(){ return sortingCriteria!= null && !sortingCriteria.isEmpty(); }
    public boolean hasFilteringCriteria(){ return filteringCriteria!=null && !filteringCriteria.isEmpty(); }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer pageNumber;
        private Integer pageSize;
        private Map<String, Object> sortingCriteria = newHashMap();
        private Map<String, Object> filteringCriteria = newHashMap();

        public Builder pageNumber(Integer pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder sortingCriteria(Map<String, Object> sortingCriteria) {
            if(sortingCriteria!=null) {
                this.sortingCriteria.putAll(sortingCriteria);
            }
            return this;
        }

        public Builder filteringCriteria(Map<String, Object> filteringCriteria) {
            if(filteringCriteria!=null) {
                this.filteringCriteria.putAll(filteringCriteria);
            }
            return this;
        }

        public ConsignmentSearchCriteria build() {
            return new ConsignmentSearchCriteria(pageNumber, pageSize, sortingCriteria, filteringCriteria);
        }

    }
}