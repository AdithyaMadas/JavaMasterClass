package Executor;

import producerConsumer.ColourConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static producerConsumer.ProducerConsumer.EOF;

//try running code without synchronized blocks, to see why we need them
public class ProducerConsumer {
    public static final String EOF = "EOF";

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        MyProducerLocks producer = new MyProducerLocks(buffer, ColourConstants.ANSI_GREEN, bufferLock);
        MyConsumerLocks consumer1 = new MyConsumerLocks(buffer, ColourConstants.ANSI_BLUE, bufferLock);
        MyConsumerLocks consumer2 = new MyConsumerLocks(buffer, ColourConstants.ANSI_RED, bufferLock);


        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(producer);
        executor.execute(consumer1);
        executor.execute(consumer2);

        //Futures are used to get an output from a thread. We can use the executor.submit() to
        // run a callable object, which is similar to a runnable object. So whatever the call method
        // returns that is stored into the FutureObject. We can access the returned value using future.get()
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ColourConstants.ANSI_PURPLE + "I'm being printed inside the call method");
                return "Callable Result";
            }
        });

        System.out.println(ColourConstants.ANSI_RESET + "Future's result: " + future.get());

        executor.shutdown(); //Both the methods don't accept and new threads after shutdown, means after calling shutdown, we can't call execute.
        // shutdownNow triggers the interrupt and tries terminating the process, shutdown doesn't. However, if interruption are not implemented, then they both
        // perform the same way.

//        executor.shutdownNow();

    }
}

class MyProducerLocks implements Runnable {
    List<String> buffer;
    String colour;
    ReentrantLock lock;

    public MyProducerLocks(List<String> buffer, String colour, ReentrantLock lock) {
        this.buffer = buffer;
        this.colour = colour;
        this.lock = lock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            System.out.println(colour + "Adding: " + num);
            lock.lock();
            try {
                buffer.add(num);
            }finally {
                lock.unlock();
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(colour+"Tried Interrupting!");
            }
        }
        System.out.println(colour + "Adding EOF: " + EOF);
        lock.lock();
        try {
            buffer.add(EOF);
        }finally {
            lock.unlock();
        }
    }
}

class MyConsumerLocks implements Runnable {
    List<String> buffer;
    String colour;
    ReentrantLock lock;

    public MyConsumerLocks(List<String> buffer, String colour, ReentrantLock lock) {
        this.buffer = buffer;
        this.colour = colour;
        this.lock = lock;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (lock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
//                    System.out.println(colour + "Counter: " + count);
                    count = 0;
                    if (buffer.get(0).equalsIgnoreCase(EOF)) {
                        System.out.println(colour + "Exiting from consumer");
                        break;
                    } else {
                        System.out.println(colour + "Read in Consumer: " + buffer.remove(0));
                    }
                } finally {
                    lock.unlock();
                }
            } else {
                count++;
            }
        }
    }
}
