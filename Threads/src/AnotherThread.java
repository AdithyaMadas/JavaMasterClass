public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ColourConstants.ANSI_CYAN + "Hello from another thread");
    }
}