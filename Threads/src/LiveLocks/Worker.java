package LiveLocks;

public class Worker {

    private String name;
    private boolean active;



    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource resource, Worker anotherWorker) {
        while (active) {
            if (resource.getOwner() != this) {
                try {
                    wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            if (anotherWorker.isActive()) {
                System.out.println(name + " : Passing resource to another worker");
                resource.setOwner(anotherWorker);
                continue;
            }
            System.out.println(name + " Working on shared resource");
            active = false;
            resource.setOwner(anotherWorker);
        }

    }

}
