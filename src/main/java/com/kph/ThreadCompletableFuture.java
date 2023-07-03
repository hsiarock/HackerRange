package com.kph;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;

public class ThreadCompletableFuture {

    public static void main(String[] args) {
        // Create a CompletableFuture representing an asynchronous task
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Task completed";
        });

        // Attach a callback to the CompletableFuture
        CompletableFuture<String> result = future.thenApplyAsync(response -> {
            // Perform some operation on the result of the task
            return "Processed result: " + response;
        });

        // Perform other operations while waiting for the task to complete

        // Retrieve the final result when it is ready
        try {
            String finalResult = result.get();
            System.out.println(finalResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void example1() {


        ExecutorService executor = Executors.newFixedThreadPool(4);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 started by thread: " + Thread.currentThread().getName());
            // Simulating some long-running task
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Result of Task 1";
        }, executor);

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2 started by thread: " + Thread.currentThread().getName());
            // Simulating some long-running task
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        }, executor);

        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (result1, result2) -> {
            System.out.println("Task 3 started by thread: " + Thread.currentThread().getName());
            return result1 + " and " + result2;
        });

//        CompletableFuture.thenAccept(result -> {
//                System.out.println("Combined result: " + result);
//        });

        // Shut down the executor service
            executor.shutdown();
    }
}






