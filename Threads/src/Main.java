public class Main {
    public static void main(String[] args) {
        System.out.println(ColourConstants.ANSI_PURPLE + "Hello from Main Thread");

        Thread anotherThread = new AnotherThread();

        anotherThread.start();

        Thread runnable = new Thread(new RunnableThread());
        runnable.start();
//        runnable.interrupt();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ColourConstants.ANSI_BLACK + "Hello World from Anonymous Runnable! ");
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(ColourConstants.ANSI_RED + "Hello from Anonymous thread");
            }
        }.start();

        System.out.println(ColourConstants.ANSI_PURPLE + "After calling another thread");

    }
}
