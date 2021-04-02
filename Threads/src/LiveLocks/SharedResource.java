package LiveLocks;

public class SharedResource {

    private Worker owner;

    public void setOwner(Worker owner) {
        this.owner = owner;
    }

    public Worker getOwner() {
        return owner;
    }
}
