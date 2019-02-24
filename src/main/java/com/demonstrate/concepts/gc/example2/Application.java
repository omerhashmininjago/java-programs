package com.demonstrate.concepts.gc.example2;

import java.util.WeakHashMap;

import static java.lang.System.gc;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * Demonstrating how WeakReferences work
 *
 */
public class Application {

    public static void main(String[] args) {
        WeakHashMap<Name, NameMetaData> dataWeakHashMap = new WeakHashMap<>();

        Name name = new Name("Omer", "Hashmi");
        dataWeakHashMap.put(name, new NameMetaData(name));

        NameMetaData nameMetaData = dataWeakHashMap.get(name);

        System.out.println(nameMetaData.getInitials());

        // if we move below line under gc() call, then we would get a different result
        name = null;
        gc();

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }

        if (dataWeakHashMap.containsValue(nameMetaData)) {
            System.out.println("GC yet to happen - still contains key");
        } else {
            System.out.println("GC done - Key gone" );
        }

    }
}
