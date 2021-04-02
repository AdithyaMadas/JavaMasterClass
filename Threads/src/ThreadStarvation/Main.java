package ThreadStarvation;

//As we don't know the order in which the Threads will be run, some threads might wait for a long time to execute,
// if a thread with high priority is used to do long tasks such as DB read, then all the other threads will have to wait
// and the whole application will slow down.

// We can use fair locks to get around this problem, they try be first come first serve,
// so if a Thread is first to wait for a lock, it'll get the lock first.
public class Main {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ColourConstants.ANSI_RED), "Thread 1");
        Thread t2 = new Thread(new Worker(ColourConstants.ANSI_BLUE), "Thread 2");
        Thread t3 = new Thread(new Worker(ColourConstants.ANSI_CYAN), "Thread 3");
        Thread t4 = new Thread(new Worker(ColourConstants.ANSI_GREEN), "Thread 4");
        Thread t5 = new Thread(new Worker(ColourConstants.ANSI_PURPLE), "Thread 5");

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(Thread.MIN_PRIORITY);

        t5.start();
        t4.start();
        t3.start();
        t2.start();
        t1.start();

    }

    static class Worker implements Runnable {
        private String colour;

        public Worker(String colour) {
            this.colour = colour;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                synchronized (lock) {
                    System.out.format(colour + "%s: Count %s\n", Thread.currentThread().getName(), i);
                }
            }
        }
    }
}
