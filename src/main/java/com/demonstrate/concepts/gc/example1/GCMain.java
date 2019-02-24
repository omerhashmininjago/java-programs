package com.demonstrate.concepts.gc.example1;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

public class GCMain {

    public static void main(String[] args) {

        List<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();

        garbageCollectorMXBeans.forEach(bean -> {
            System.out.println("Name :: " + bean.getName());
            System.out.println("Number of Collections :: " + bean.getCollectionCount());
            System.out.println("Collection Time :: " + bean.getCollectionTime());
            System.out.println("Pool Name :: ");
            for(String poolName : bean.getMemoryPoolNames()) {
                System.out.println(poolName);
            }
            System.out.println("________________________________________________________");
        });
    }
}
