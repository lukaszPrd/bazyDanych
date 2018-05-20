package studia.bazy.danych.logistyka.application.root;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import studia.bazy.danych.logistyka.application.converter.DozerConverterImpl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@Configuration
public class DozerConverterImplConfiguration {

    @Bean
    public DozerConverterImpl dozerConverter(DozerBeanMapper dozerBeanMapper){
        return new DozerConverterImpl(dozerBeanMapper);
    }

    @Bean
    public DozerBeanMapper dozerBeanMapper(@Autowired(required = false) List<CustomConverter> converters, @Autowired(required = false) List<BeanMappingBuilder> mappings) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        if (CollectionUtils.isNotEmpty(mappings)) {
            mappings.forEach(mapper::addMapping);
        }

        Map<String, CustomConverter> converterMap = converters
                .stream()
                .collect(toMap(new Function<CustomConverter, String>() {
                    @Override
                    public String apply(CustomConverter t) {
                        return t.getClass().getSimpleName();
                    }
                }, Function.identity()));

        mapper.setCustomConvertersWithId(converterMap);

        return mapper;
    }

}
