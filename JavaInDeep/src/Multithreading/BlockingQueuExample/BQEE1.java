package Multithreading.BlockingQueuExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BlockingQueue<T>{
    private final Queue<T> queue=new LinkedList<>();
    private final int capacity;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public BlockingQueue(int capacity){
        this.capacity=capacity;
    }

    public void put(T item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                System.out.println("full , waiting .. by " + Thread.currentThread().getName());
                notFull.await();
            }
            queue.add(item);
            notEmpty.signalAll();
        }finally{
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try{
            while(queue.isEmpty()){
                System.out.println("empty , waiting .. by " + Thread.currentThread().getName());
                notEmpty.await();
            }
            T item = queue.poll();
            notFull.signalAll();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }


    }

}



public class BQEE1 {
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue= new BlockingQueue<Integer>(3);
        Runnable producer = ()->{
            int value=0;
            while(true){
                System.out.println("producing :" + value + " by "  +Thread.currentThread().getName());
                try {
                    blockingQueue.put(value++);
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable consumer = ()->{
            while(true){
                int item = blockingQueue.take();
                System.out.println("consumed : " + item + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

