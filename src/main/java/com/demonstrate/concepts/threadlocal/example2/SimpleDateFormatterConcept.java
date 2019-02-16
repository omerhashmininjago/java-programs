package com.demonstrate.concepts.threadlocal.example2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatterConcept {

    //Date Format not threadsafe
    private DateFormat df = new SimpleDateFormat("MM/dd/yy");

    /**
     *As Date Format is not thread safe - we would need this to be synchronized
     *
     * @return
     */
    public synchronized String formatCurrentDate() {
        //DateFormat df = new SimpleDateFormat("MM/dd/yy"); Bad practise hence moving to class level
        return df.format(new Date());
    }

    /**
     * As Date Format is not thread safe - we would need this to be synchronized
     *
     * But using synchronization, introduces a bottleneck in the application - as threads now have to wait
     * hence performance issues
     *
     * @return
     */
    public synchronized String formatFirstOfJanyary1970() {
        //DateFormat df = new SimpleDateFormat("MM/dd/yy");
        return df.format(new Date(0));
    }
}
