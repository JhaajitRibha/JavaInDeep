package Multithreading.Executors.NewScheduledThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NSTPA2 {
    static int counter = 1;

    public static void main(String[] args) {


//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//        System.out.println("execution started .. : " + System.currentTimeMillis());
//
//        executorService.scheduleAtFixedRate(()->{
//            System.out.println("Counter : " + counter);
//            System.out.println("executed completed at : " + System.currentTimeMillis());
//            counter++;
//
//            if(counter==4){
//                executorService.shutdown();
//            }
//        },20000,4000, TimeUnit.MILLISECONDS);


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        System.out.println("Execution started at: " + System.currentTimeMillis());

        for (int i = 0; i < 8; i++) {
            int taskId = i;
            executorService.scheduleAtFixedRate(() -> {
                System.out.println("Task " + taskId + " - Counter: " + counter);
                System.out.println("Task " + taskId + " executed at: " + System.currentTimeMillis());
                counter++;

                if (counter >= 16) {
                    executorService.shutdown();
                }
            }, 0, 2, TimeUnit.SECONDS);
        }
    }
}
