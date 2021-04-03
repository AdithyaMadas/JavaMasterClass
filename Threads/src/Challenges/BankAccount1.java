package Challenges;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount1 {

    private double balance;
    private String accountNumber;
    ReentrantLock lock;

    public BankAccount1(String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Couldn't acquire lock!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    balance -= amount;
                    balance -= amount;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Couldn't acquire lock!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Status = " + status);
    }

    /*public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        synchronized (this) {
            balance -= amount;
        }
    }*/

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account Number: " + accountNumber);
    }
}
