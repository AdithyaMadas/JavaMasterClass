package LiveLocks;


//Both Threads are actively running and are not blocked, but make no progress.
public class Main {

    public static void main(String[] args) {

        final SharedResource sharedResource = new SharedResource();

        Worker worker1 = new Worker("Worker 1", true);
        Worker worker2 = new Worker("Worker 2", true);

        sharedResource.setOwner(worker1);

    new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();
    }
}
