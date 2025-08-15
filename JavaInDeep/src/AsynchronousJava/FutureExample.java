package AsynchronousJava;


//Future is a class introduced in Java 5 that
// represents the result of an asynchronous computation.
// It provides a way to check if the computation is complete,
// wait for its completion, and retrieve the result.


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample{

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread.currentThread().getState();

        ExecutorService executorService  = Executors.newFixedThreadPool(3);

        Future<Integer> futureTask = executorService.submit(()->{

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 42;

        });

        Future<String> futureTaskForString  = executorService.submit(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "ajit jjha";
        });

        Future<TravelStore> futureTravel = executorService.submit(()->{
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return new TravelStore("kolkata","400km from jharkhand", LocalDate.now().plusMonths(6),LocalDate.now().plusWeeks(28));
        });

        System.out.println("doing some other task ...");
        System.out.println("doing some various other task ");

        int res = futureTask.get();

        System.out.println("result is " + res);

        System.out.println("executing other thread task ..");

        String name = futureTaskForString.get();

        System.out.println("name : " + name);

        System.out.println("after 1 month : notification coming ");
        TravelStore travelDetail = futureTravel.get();

        System.out.println(travelDetail.toString());


        executorService.shutdown();




    }
}


//In the provided code, after invoking the get() method on the Future object futureTask,
// the program is waiting for the result of the asynchronous computation to become
// available. This behavior is expected because the get() method is a blocking call,
// meaning it will wait until the result is available or the computation is completed.

//The purpose of using Future in this scenario is to obtain the result of the
// asynchronous computation performed by the submitted task. Even though the Future
// itself represents a future result, calling get() on it blocks the current thread
// until the result becomes available. This is useful in scenarios where you need to
// obtain the result of a computation performed asynchronously and continue processing
// based on that result.
