package LambdaStream.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void main(String[] args) {

        System.out.println("in middle");
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "task from future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "task from source2";
        });


        System.out.println("in middle2");
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2,(res1,res2)->{
            return res1 +  " and " + res2;
        });

        combinedFuture.thenAccept(System.out::println);

        combinedFuture.join();

        System.out.println("finished");
    }

}
