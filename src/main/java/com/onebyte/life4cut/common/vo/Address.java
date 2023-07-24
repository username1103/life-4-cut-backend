package com.onebyte.life4cut.common.vo;

import com.onebyte.life4cut.common.attributeconverter.ZipcodeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "basic_address")
    private String address;

    @Column(name = "detail_address")
    private String detail;

    @Column()
    @Convert(converter = ZipcodeConverter.class)
    private Zipcode zipcode;

    protected Address() {}

    public Address(String address, String detail, Zipcode zipcode) {
        this.address = address;
        this.detail = detail;
        this.zipcode = zipcode;
    }
}