package com.onebyte.life4cut.common.vo;


import lombok.Value;

@Value
public class Zipcode {

    private static int LENGTH = 5;

    String value;

    private Zipcode(String value) {
        this.value = value;
    }

    public static Zipcode of(String value) {
        if (value.length() != LENGTH || !isInteger(value)) {
            throw new IllegalArgumentException("유효하지 않은 Zipcode 입니다");
        }

        return new Zipcode(value);
    }

    private static Boolean isInteger(String value) {
        if (value == null) {
            return false;
        }

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
