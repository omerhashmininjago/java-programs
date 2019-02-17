package com.demonstrate.concepts.enumerations.example3;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum CrudeOil {

    PETROL,
    DIESEL,
    GAS;

    CrudeOil() {

    }

    public static CrudeOil getCrudeOilType(String crudeOil) throws Exception {
        if (StringUtils.isEmpty(crudeOil)) {
            throw new Exception("Input is null - Here is the list of valid CrudeOils " + Arrays.toString(CrudeOil.values()));
        }
        for (CrudeOil type : CrudeOil.values()) {
            if (crudeOil.trim().toUpperCase().equals(type.name())) {
                return type;
            }
        }
        throw new Exception("Invalid CrudeOil - Here is the list of valid CrudeOils " + Arrays.toString(CrudeOil.values()));
    }
}
