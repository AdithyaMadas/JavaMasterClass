package Challenges;

public class Challenge1 {

    public static void main(String[] args) {
        BankAccount1 bankAccount1 = new BankAccount1("123-456789", 1000.00);

        new Thread(){
            @Override
            public void run() {
                bankAccount1.deposit(300.00);
                bankAccount1.withdraw(50.00);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                bankAccount1.deposit(203.75);
                bankAccount1.withdraw(100.00);
            }
        }.start();

    }
}
