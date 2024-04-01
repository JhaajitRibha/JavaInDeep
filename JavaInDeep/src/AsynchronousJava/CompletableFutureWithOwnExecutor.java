package AsynchronousJava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CompletableFutureWithOwnExecutor {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 executing on thread: " + Thread.currentThread().getName());
            return 20;
        }, executor);

        future.thenApplyAsync(result -> {
            System.out.println("Task 2 executing on thread: " + Thread.currentThread().getName());
            return result * 2;
        }, executor);

        future.thenAcceptAsync(result -> {
            System.out.println("Task 3 executing on thread: " + Thread.currentThread().getName());
            System.out.println("Final Result: " + result);
        }, executor);
    }

}
