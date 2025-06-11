package org.example.models.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Objects;

@Converter(autoApply = true)
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return Objects.nonNull(value) && value ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return "Y".equals(value);
    }
}
