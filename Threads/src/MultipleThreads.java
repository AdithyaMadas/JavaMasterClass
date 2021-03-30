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
        for (i = 0; i < 10; i++) {
            System.out.println(colour + "i : " + i);
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
