package com.onebyte.life4cut.common.vo;

import com.onebyte.life4cut.common.vo.Zipcode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter()
public class ZipcodeConverter implements AttributeConverter<Zipcode, String> {

    @Override
    public String convertToDatabaseColumn(Zipcode attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public Zipcode convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new Zipcode(dbData);
    }
}
