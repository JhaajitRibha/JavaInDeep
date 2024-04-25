package Multithreading;

public class DaemonThreadExample {
    public static void main(String[] args) {
        // Create a daemon thread
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Mark the thread as daemon
        daemonThread.setDaemon(true);

        // Start the daemon thread
        daemonThread.start();

        // Main thread sleeps for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread exiting...");
    }
}
