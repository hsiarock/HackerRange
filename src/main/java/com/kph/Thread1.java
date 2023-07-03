package com.kph;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;

public class Thread1 {
    static Object lock = new Object();
    public static void main(String[] args) {

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        });
        t1.start();
        t2.start();
        System.out.println("Counter: " + counter.getCount());

        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(7));

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        for (String item : list) {
            if (item.equals("Two")) {
                list.remove(item);
            }
        }

        System.out.println("------- print all elememet in List -----");
        for (String item : list) {
            System.out.println(item);
        }
    }


    public CompletableFuture<String> doFoo() {
        CompletableFuture<String> fooFuture = new CompletableFuture<>();

        try {
            String fooResult = "completed"; //longOp();
            fooFuture.complete(fooResult);
        } catch (Exception e) {
            fooFuture.completeExceptionally(e);
        }

        return fooFuture;
    }
}

class Counter {
    private int count = 0;
    public void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
