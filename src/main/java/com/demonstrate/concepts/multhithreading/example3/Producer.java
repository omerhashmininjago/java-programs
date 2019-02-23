package com.demonstrate.concepts.multhithreading.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Producer implements Runnable {

    private Queue<Name> buffer;
    private Object lock;
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
                    }
                }
                System.out.println(name + " is ready for consumption");
                //perform task
                lock.notifyAll();
            }
        });
    }
}