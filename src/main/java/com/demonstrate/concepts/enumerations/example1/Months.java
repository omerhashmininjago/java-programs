package com.demonstrate.concepts.enumerations.example1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public enum Months {

    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    Months(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    private final int monthNumber;

    /**
     * Its best to iterate over the Enum with in the Enum class to avoid boilerplate code through out the app
     *
     * @param month
     * @return Month
     * @throws Exception
     */
    public static Months getMonth(String month) throws Exception {
        if (StringUtils.isEmpty(month)) {
            throw new Exception("Input is null - Here is the list of valid months " + Arrays.toString(Months.values()));
        }
        for (Months m : Months.values()) {
            if (month.trim().toUpperCase().equals(m.name())) {
                return m;
            }
        }
        throw new Exception("Invalid Month - Here is the list of valid months " + Arrays.toString(Months.values()));
    }

}
