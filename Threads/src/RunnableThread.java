public class RunnableThread implements Runnable {
    @Override
    public void run() {
        try{
            Thread.sleep(3000l);
            System.out.println(ColourConstants.ANSI_GREEN + "Hello from Runnable Thread after sleep");
        } catch (InterruptedException e) {
            System.out.println(ColourConstants.ANSI_GREEN + "I have been interrupted");
        }
    }
}
