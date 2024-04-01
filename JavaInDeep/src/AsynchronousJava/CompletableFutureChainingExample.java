package AsynchronousJava;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChainingExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> futureTask = CompletableFuture.supplyAsync(()->{

            System.out.println("in first task ..");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 1;


        });

        futureTask.thenApply((res)->{
            System.out.println("in second task ...");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            res*=2;
            return res;
        }).thenApply((res)->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            res+=5;
            return res;
        }).thenAccept((res)->{
            System.out.println("res is " + res);
        }).join();





    }

}
