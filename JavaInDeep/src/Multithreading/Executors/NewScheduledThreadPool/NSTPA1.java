package Multithreading.Executors.NewScheduledThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NSTPA1 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        System.out.println("task executed at : " + System.currentTimeMillis());

        executorService.schedule(()->{
            System.out.println("Task executed at : " + System.currentTimeMillis());
        },2, TimeUnit.MINUTES);

        executorService.shutdown();
    }
}
