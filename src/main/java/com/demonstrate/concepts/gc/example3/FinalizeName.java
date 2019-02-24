package com.demonstrate.concepts.gc.example3;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class FinalizeName extends PhantomReference<Name> {

    /**
     * Creates a new phantom reference that refers to the given object and
     * is registered with the given queue.
     *
     * <p> It is possible to create a phantom reference with a <tt>null</tt>
     * queue, but such a reference is completely useless: Its <tt>get</tt>
     * method will always return null and, since it does not have a queue, it
     * will never be enqueued.
     *
     * @param referent the object the new phantom reference will refer to
     * @param q        the queue with which the reference is to be registered,
     */
    public FinalizeName(Name referent, ReferenceQueue<? super Name> q) {
        super(referent, q);
    }

    public void cleanUp () {
        System.out.println("CLean up activities can be performed here");
    }
}
