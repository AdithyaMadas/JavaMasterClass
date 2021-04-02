package Executor;


import producerConsumer.ColourConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static producerConsumer.ProducerConsumer.EOF;

//ArrayBlockingQueue is a Thread safe queue, like any queue it is FIFO, only one Thread can put or take elements from the queue when executing,
// queue doesn't stop processing in the middle
public class ProducerConsumerWithArrayBlockingQueue {
    public static final String EOF = "EOF";

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        MyProducerLocksWithArrayBlockingQueue producer = new MyProducerLocksWithArrayBlockingQueue(buffer, ColourConstants.ANSI_GREEN);
        MyConsumerLocksWithArrayBlockingQueue consumer1 = new MyConsumerLocksWithArrayBlockingQueue(buffer, ColourConstants.ANSI_BLUE);
        MyConsumerLocksWithArrayBlockingQueue consumer2 = new MyConsumerLocksWithArrayBlockingQueue(buffer, ColourConstants.ANSI_RED);


        ExecutorService executor = Executors.newFixedThreadPool(5);

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

class MyProducerLocksWithArrayBlockingQueue implements Runnable {
    ArrayBlockingQueue<String> buffer;
    String colour;

    public MyProducerLocksWithArrayBlockingQueue(ArrayBlockingQueue<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            System.out.println(colour + "Adding: " + num);
            try {
                buffer.put(num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(colour + "Tried Interrupting!");
            }
        }
        System.out.println(colour + "Adding EOF: " + EOF);
        try {
            buffer.put(EOF);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyConsumerLocksWithArrayBlockingQueue implements Runnable {
    ArrayBlockingQueue<String> buffer;
    String colour;

    public MyConsumerLocksWithArrayBlockingQueue(ArrayBlockingQueue<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.peek().equalsIgnoreCase(EOF)) {
                    System.out.println(colour + "Exiting from consumer");
                    break;
                } else {
                    try {
                        System.out.println(colour + "Read in Consumer: " + buffer.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

