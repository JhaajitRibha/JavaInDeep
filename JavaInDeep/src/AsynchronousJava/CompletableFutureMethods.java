package AsynchronousJava;


//1. thenApply
//
//        thenApply is used to perform an operation on the result of a
//        CompletableFuture and return a new CompletableFuture with the
//        result of the operation. It takes a Function as an argument,
//        which specifies the transformation to be applied to the result.

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureMethods {
    //then apply
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       CompletableFuture.supplyAsync(() -> {
            return "ajit";
        }).thenApply((res) -> {
            return res + "1";
        }).thenApply((res) -> {
            return res + "2";
        }).thenAccept((res) -> System.out.println(res)).join();

       //then compose

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Integer> resultFuture = future.thenCompose(value ->
                CompletableFuture.supplyAsync(() -> value * 2));

        System.out.println(resultFuture.get());

        //then Combine

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> resultFuture2 = future1.thenCombine(future2, (value1, value2) -> value1 + value2);

        System.out.println(resultFuture2.get());


        //then combine second example

        CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(()->{
            System.out.println("in first task ..");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100.0;
        });

        CompletableFuture<Double> discountPrice = CompletableFuture.supplyAsync(()->{
            System.out.println("in second task");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 14.0;
        });

        futurePrice.thenCombine(discountPrice,(p1,p2)->{
            System.out.println("in combine");
            try {
                Thread.sleep(16000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return p1-p2;
        }).thenAccept((price)-> System.out.println("after discount, final price : "+ price)).join();



    }


}

