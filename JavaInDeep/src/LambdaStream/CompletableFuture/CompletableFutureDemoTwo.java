package LambdaStream.CompletableFuture;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemoTwo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("async task completed");
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return " waah jee";
        });



        future.join();
        future2.join();

        String res = future2.get();


        System.out.println(res);

        System.out.println("finished");
    }

}
