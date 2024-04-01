package Multithreading.ForkJoing;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumCalculator extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 5; // Threshold for splitting tasks
    private int[] array;
    private int start;
    private int end;

    public SumCalculator(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if ((end - start) <= THRESHOLD) {
            // If the task size is below threshold, compute it directly
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Otherwise, split the task into smaller subtasks
            int mid = (start + end) / 2;
            SumCalculator leftTask = new SumCalculator(array, start, mid);
            SumCalculator rightTask = new SumCalculator(array, mid, end);

            // Fork the left subtask and execute it asynchronously
            leftTask.fork();

            // Compute the right subtask in the current thread
            int rightResult = rightTask.compute();

            // Join the result of the left subtask
            int leftResult = leftTask.join();

            // Combine the results of both subtasks
            return leftResult + rightResult;
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Create a ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        System.out.println("Pool Parallelism: " + forkJoinPool.getParallelism());

        // Create a task to compute the sum of elements in the array
        SumCalculator task = new SumCalculator(array, 0, array.length);

        // Execute the task and get the result
        int result = forkJoinPool.invoke(task);

        // Print the result
        System.out.println("Sum: " + result);
    }


}
