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
