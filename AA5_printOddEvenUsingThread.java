
//created two threads
//created two methods to be called from each thread
//used shared counter and LOCK
//LOCK.wait() to send current thread in waiting state for LOCK, It will be in waiting state until it is notified
//LOCK.notify(): that's why we are using to notify others that LOCK is going to be available soon
//At the end of each method we again used LOCK.notify() otherwise program execution will not terminate

public class AA5_printOddEvenUsingThread {
    private static int count = 1;
    private static Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread odd = new Thread(() -> {
            try {
                printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread even = new Thread(() -> {
            try {
                printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        odd.start();
        even.start();

        odd.join();
        even.join();

        System.out.println("Program execution completed");
    }

    public static void printOdd() throws InterruptedException {
        synchronized (LOCK) {
            while (count <= 10) {

                System.out.println("Odd Number: " + count);
                count++;
                LOCK.notify();
                LOCK.wait();

                Thread.sleep(500);
            }
            LOCK.notify();
        }
    }

    public static void printEven() throws InterruptedException {
        synchronized (LOCK) {
            while (count <= 10) {
                if (count == 1) {
                    LOCK.wait();
                }
                System.out.println("Even Number: " + count);
                count++;
                LOCK.notify();
                LOCK.wait();

                Thread.sleep(500);
            }
            LOCK.notify();
        }
    }

}
