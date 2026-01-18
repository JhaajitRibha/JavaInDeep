package Multithreading.Callable;

import java.util.concurrent.*;

public class CallableE1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> task1 = new WorkingThread();
        Callable<String> task2 = new WorkingThreadTwo();
        Callable<String> task3 = new WorkingThreadThree();
        Future<String> result = executorService.submit(task1);
        Future<String> result2 = executorService.submit(task2);
        Future<String> result3 = executorService.submit(task3);

        System.out.println(result.get());
        System.out.println(result2.get());
        System.out.println(result3.get());
        executorService.shutdown();

    }

}

class WorkingThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "ajit + " + " by " + Thread.currentThread().getName();
    }
}

class WorkingThreadTwo implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "samar " + " by " + Thread.currentThread().getName();
    }
}

class WorkingThreadThree implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "rahul " + " by " + Thread.currentThread().getName();
    }
}
