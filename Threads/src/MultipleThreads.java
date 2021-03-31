public class MultipleThreads {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread counterThread1 = new CounterThread(counter);
        counterThread1.setName("Thread 1");
        Thread counterThread2 = new CounterThread(counter);
        counterThread1.setName("Thread 2");

        counterThread1.start();
        counterThread2.start();
    }
}

class Counter {
    private int i;
    // public synchronized void count() { we can synchronize the entire method, won't stop in between the method execution.
    public void count() {
        String colour;
        switch (Thread.currentThread().getName()) {
            case "Thread 1":
                colour = ColourConstants.ANSI_RED;
                break;
            case "Thread 2":
                colour = ColourConstants.ANSI_GREEN;
                break;
            default:
                colour = ColourConstants.ANSI_BLUE;
        }
        synchronized (this) { // synchronized block first acquires a lock for the given variable, only one thread can have a lock at a time,
            // so only one thread runs it at a time, this refers to the object, as the same object are being used, this works.
            for (i = 0; i < 10; i++) {
                System.out.println(colour + "i : " + i);
            }
        }
    }
}

class CounterThread extends Thread {

    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }


    @Override
    public void run() {
        counter.count();
    }
}
