package studia.bazy.danych.logistyka.application.converter;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class DozerConverterImpl {

    private DozerBeanMapper mapper;

    @Autowired
    public DozerConverterImpl(DozerBeanMapper mapper) {
        this.mapper = mapper;
    }

    public <TO> Map<String, Object> convertToMap(TO to) {
        return convertToMap(to, null);
    }

    public <TO> Map<String, Object> convertToMap(TO object, String mappingId) {
        return convert(object, HashMap.class, mappingId);
    }

    public <TOIn, TOOut> List<TOOut> convert(Collection<TOIn> collection, Class<TOOut> toOutClass) {
        return convert(collection, toOutClass, null);
    }

    public <TOIn, TOOut> List<TOOut> convert(Collection<TOIn> collection, Class<TOOut> toOutClass, String mappingId) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        List<TOOut> result = Lists.newArrayListWithCapacity(collection.size());
        for (TOIn in : collection) {
            result.add(convert(in, toOutClass, mappingId));
        }
        return result;
    }

    public <TO, VO> VO convert(TO to, Class<VO> voClass) {
        return convert(to, voClass, null);
    }

    public <TO, VO> VO convert(TO to, Class<VO> voClass, String mappingId) {
        if (to == null) {
            return null;
        }
        return isNotBlank(mappingId) ?
                mapper.map(to, voClass, mappingId) :
                mapper.map(to, voClass);
    }

    public <In, Out> void update(In updator, Out toUpdate) {
        update(updator, toUpdate, null);

    }

    public <In, Out> void update(In updator, Out toUpdate, String mappingId) {
        if (updator != null) {
            if (isNotBlank(mappingId)) {
                mapper.map(updator, toUpdate, mappingId);
            } else {
                mapper.map(updator, toUpdate);
            }
        }
    }

    public <In, Out> Out updateOrConvert(In updator, Out toUpdate, Class<? extends Out> toOutClass) {
        if (toUpdate == null) {
            return convert(updator, toOutClass);
        }
        update(updator, toUpdate);
        return toUpdate;
    }

    public <TO> String toString(TO to) {
        return String.valueOf(to);
    }

    public <TOIn> List<String> toString(Collection<TOIn> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = Lists.newArrayListWithCapacity(collection.size());
        for (TOIn in : collection) {
            result.add(toString(in));
        }
        return result;
    }
}