package com.demonstrate.concepts.gc.example3;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import static java.lang.System.gc;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * Demonstrating how Phantom Reference and Reference Queue work
 */
public class Application {

    public static void main(String[] args) {

        ReferenceQueue<Name> referenceQueue = new ReferenceQueue<>();

        List<Name> nameList = new ArrayList<>();
        List<FinalizeName> finalizeNameList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Name name = new Name("Omer", " " + i);
            nameList.add(name);
            finalizeNameList.add(new FinalizeName(name, referenceQueue));
        }

        nameList = null;
        gc();

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            currentThread().interrupt();
        }

        for(PhantomReference<Name> finalizeName : finalizeNameList) {
            System.out.println(finalizeName.isEnqueued());
        }

        Reference<? extends Name> referenceFromQueue;

        while((referenceFromQueue = referenceQueue.poll()) != null) {
            ((FinalizeName) referenceFromQueue).cleanUp();
        }

        for(PhantomReference<Name> finalizeName : finalizeNameList) {
            System.out.println(finalizeName.isEnqueued());
        }
    }
}
