package studia.bazy.danych.logistyka.application.converter;

import org.springframework.stereotype.Component;

@Component
public class EnumToStringConverter extends BaseCustomConverter {
    @Override
    public Object convert(ConverterContext ctx) throws Exception {
        return String.class.isAssignableFrom(ctx.getSourceClass()) ?
                fromString(ctx) : fromEnum(ctx);
    }

    private Object fromString(ConverterContext ctx) {
        return Enum.valueOf((Class) ctx.getDestinationClass(), (String) ctx.getSourceFieldValue());
    }


    private Object fromEnum(ConverterContext ctx) {
        return ((Enum) ctx.getSourceFieldValue()).name();
    }
}