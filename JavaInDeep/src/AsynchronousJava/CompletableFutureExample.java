package AsynchronousJava;

//CompletableFuture was introduced in Java 8 as an enhancement over Future.
// It provides a more flexible and powerful API for asynchronous programming,
// including support for chaining and combining asynchronous tasks.

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CompletableFutureExample {

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> futureTask = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(10000);
                System.out.println("in future task execution .... ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });


        System.out.println("doing some thing ...");
        Thread.sleep(5000);
        System.out.println("doing some other thing ..");

        futureTask.join();
        futureTask.thenRun(()-> System.out.println("Task completed .."));

        CompletableFuture<TravelStore> futureTaskWithRes = CompletableFuture.supplyAsync(()->{
            System.out.println("in supply async ..");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return new TravelStore("Goa","1200km",
                    LocalDate.now().plusYears(1),
                    LocalDate.now().plusYears(1)
                    .plusMonths(1));
        });

        System.out.println("doing other task after void future ...");
        System.out.println("notification after 1 year: ");

        futureTaskWithRes.thenAccept((res)->{
            System.out.println(res.toString());
        }).join();





    }

}
