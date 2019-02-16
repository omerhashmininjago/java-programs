package com.demonstrate.concepts.threadlocal.example2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalSimpleDateFormatterConcept {

    //This can be non static as well
    public static ThreadLocal<DateFormat> df = ThreadLocal.withInitial(() -> new SimpleDateFormat("MM/dd/yy"));

    public String formatCurrentDate() {
        return df.get().format(new Date());
    }

    public String formatFirstOfJanyary1970() {
        return df.get().format(new Date(0));
    }
}
