package com.demonstrate.concepts.multhithreading.example3;

import java.util.List;
import java.util.Queue;

import static java.lang.Thread.interrupted;

public class Producer implements Runnable {

    private final Queue<Name> buffer;
    private final Object lock;
    private List<Name> nameList;

    public Producer(Queue<Name> buffer, Object lock, List<Name> nameList) {
        this.buffer = buffer;
        this.lock = lock;
        this.nameList = nameList;
    }

    @Override
    public void run() {

        nameList.forEach(name -> {
            synchronized (lock) {
                while (!buffer.offer(name)) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Producer Thread interrupted");
                        interrupted();
                    }
                }
                System.out.println(name + " is ready for consumption");
                lock.notifyAll();
            }
        });
    }
}
