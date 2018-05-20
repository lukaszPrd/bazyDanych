package studia.bazy.danych.logistyka.application.converter;

import org.apache.commons.lang3.StringUtils;
import org.dozer.ConfigurableCustomConverter;
import org.dozer.CustomConverter;
import org.dozer.converters.ConversionException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseCustomConverter implements CustomConverter, ConfigurableCustomConverter {

    private String parameter;

    @Override
    public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        ConverterContext ctx = createContext(existingDestinationFieldValue, sourceFieldValue, destinationClass, sourceClass);
        Object result = null;
        try {
            result = tryConvert(ctx);
        } catch (Exception e) {
            onConvertionFailure(ctx, e);
        }
        return result;
    }

    public Object tryConvert(ConverterContext ctx) throws Exception {
        return ctx.getSourceFieldValue() != null ? convert(ctx) : null;
    }

    public void onConvertionFailure(ConverterContext ctx, Exception failureCause) {
        throw new ConversionException("Dozer conversion problem : " + failureCause.getMessage() + " Context: " + ctx, failureCause);
    }

    private ConverterContext createContext(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
        ConverterContext ctx = new ConverterContext();
        ctx.setExistingDestinationFieldValue(existingDestinationFieldValue);
        ctx.setSourceFieldValue(sourceFieldValue);
        ctx.setDestinationClass(destinationClass);
        ctx.setSourceClass(sourceClass);
        ctx.setParameter(parameter);
        return ctx;
    }

    public abstract Object convert(ConverterContext ctx) throws Exception;

    @Override
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public static class ConverterContext {
        private Object existingDestinationFieldValue;
        private Object sourceFieldValue;
        private Class<?> destinationClass;
        private Class<?> sourceClass;
        private String parameter;

        public Object getExistingDestinationFieldValue() {
            return existingDestinationFieldValue;
        }

        public void setExistingDestinationFieldValue(Object existingDestinationFieldValue) {
            this.existingDestinationFieldValue = existingDestinationFieldValue;
        }

        @SuppressWarnings("unchecked")
        public <T> T getSourceFieldValue() {
            return (T) sourceFieldValue;
        }

        public void setSourceFieldValue(Object sourceFieldValue) {
            this.sourceFieldValue = sourceFieldValue;
        }

        public Class<?> getDestinationClass() {
            return destinationClass;
        }

        public boolean isSourceFieldPrimitive() {
            return getSourceFieldValue().getClass().isPrimitive();
        }

        public boolean isSourceFieldMap() {
            return Map.class.isAssignableFrom(getSourceFieldValue().getClass());
        }

        public boolean isSourceFieldIterable() {
            return Iterable.class.isAssignableFrom(getSourceFieldValue().getClass());
        }

        public void setDestinationClass(Class<?> destinationClass) {
            this.destinationClass = destinationClass;
        }

        public Class<?> getSourceClass() {
            return sourceClass;
        }

        public void setSourceClass(Class<?> sourceClass) {
            this.sourceClass = sourceClass;
        }


        public boolean hasParameter() {
            return StringUtils.isNotBlank(parameter);
        }

        public String getParameter() {
            return parameter;
        }

        public void setParameter(String parameter) {
            this.parameter = parameter;
        }

        public Class<?> getParameterAsClass() {
            try {
                return Class.forName(parameter);
            } catch (ClassNotFoundException e) {
                throw new ConversionException("Could not lookup converter parameter class : " + parameter, e);
            }
        }

        public List<Class<?>> getParameterListAsClasses() {
            try {
                List<Class<?>> list = new LinkedList<Class<?>>();
                for (String clazz : getParameterList()) {
                    list.add(Class.forName(clazz));
                }
                return list;
            } catch (ClassNotFoundException e) {
                throw new ConversionException("Could not lookup converter parameter class : " + parameter, e);
            }
        }

        public List<String> getParameterList() {
            return Arrays.asList(parameter.split(";"));
        }
    }

}