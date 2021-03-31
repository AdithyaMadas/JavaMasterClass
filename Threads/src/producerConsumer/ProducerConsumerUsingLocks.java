package producerConsumer;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static producerConsumer.ProducerConsumer.EOF;

public class ProducerConsumerUsingLocks {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ColourConstants.ANSI_GREEN);
        MyConsumer consumer1 = new MyConsumer(buffer, ColourConstants.ANSI_BLUE);
        MyConsumer consumer2 = new MyConsumer(buffer, ColourConstants.ANSI_RED);


        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyProducer implements Runnable {
    List<String> buffer;
    String colour;

    public MyProducer(List<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums) {
            System.out.println(colour + "Adding: " + num);
            synchronized (buffer) {
                buffer.add(num);
            }

            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
        System.out.println(colour + "Adding EOF: " + EOF);
        synchronized (buffer) {
            buffer.add(EOF);
        }
    }
}

class MyConsumer implements Runnable {
    List<String> buffer;
    String colour;

    public MyConsumer(List<String> buffer, String colour) {
        this.buffer = buffer;
        this.colour = colour;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                } else if (buffer.get(0).equalsIgnoreCase(EOF)) {
                    System.out.println(colour + "Exiting from consumer");
                    break;
                } else {
                    System.out.println(colour + "Read in Consumer: " + buffer.remove(0));
                }
            }
        }
    }
}