package DeadLocks;

public class DeadLock {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1 has lock 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 waiting for lock 2");
                synchronized (lock2) {
                    System.out.println("Thread 1 has lock 1 and lock 2");
                }
                System.out.println("Thread 1 has released lock 2");
            }
            System.out.println("Thread 1 has released lock 1");
        }
    }


    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2 has lock 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 waiting for lock 1");

                synchronized (lock1) {
                    System.out.println("Thread 2 has lock 1 and lock 2");
                }
                System.out.println("Thread 2 has released lock 1");
            }
            System.out.println("Thread 2 has released lock 2");
        }
    }
}
