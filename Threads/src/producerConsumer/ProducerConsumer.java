package producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static producerConsumer.ProducerConsumer.EOF;

//try running code without synchronized blocks, to see why we need them
public class ProducerConsumer {
    public static final String EOF = "EOF";

    public static void main(String[] args) {

        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();

        MyProducerLocks producer = new MyProducerLocks(buffer, ColourConstants.ANSI_GREEN, bufferLock);
        MyConsumerLocks consumer1 = new MyConsumerLocks(buffer, ColourConstants.ANSI_BLUE, bufferLock);
        MyConsumerLocks consumer2 = new MyConsumerLocks(buffer, ColourConstants.ANSI_RED, bufferLock);


        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
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
        while (true) {
            int count = 0;
            if (lock.()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(colour + "Counter: " + count);
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
