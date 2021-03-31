import java.util.Random;

public class DeadLocks_Producer_Consumer {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();
    }
}

class Message {
    private String message;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait(); // when wait is called, it stops the thread till another thread calls notify() or notifyAll(). Once, that is called it resumes again.
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        notifyAll();
        this.message = message;
    }
}

class Producer implements Runnable{
    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messageString = {"Line1",
                "Line 2",
                "Line 3",
                "Line 4"};

        Random random = new Random();

        for (int i = 0; i < messageString.length; i++) {
            message.write(messageString[i]);
            try{
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }

        message.write("Finished!");
    }
}


class Consumer implements Runnable {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String latestMessage = message.read(); !latestMessage.equalsIgnoreCase("Finished!"); latestMessage = message.read()) {
            System.out.println("Message: " + latestMessage);
            try{
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
    }
}