import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    private Branch findBranch(String name) {
        for (Branch i : branches) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    public boolean addBranch(String name) {
        if (findBranch(name) != null) {
            return false;
        }
        branches.add(new Branch(name));
        return true;
    }

    public boolean addCustomer(String name, String customerName, double init) {
        Branch branch = findBranch(name);
        if (branch == null) {
            return false;
        }
        return branch.newCustomer(customerName, init);
    }

    public boolean addCustomerTransaction(String name, String customerName, double init) {
        Branch branch = findBranch(name);
        if (branch == null) {
            return false;
        }
        return branch.addCustomerTransaction(customerName, init);
    }

    public boolean listCustomers(String name, boolean printTransactions) {
        Branch branch = findBranch(name);
        if (branch == null) {
            return false;
        }
        System.out.println("Customer details for branch "+branch.getName());
        ArrayList<Customer> customers = branch.getCustomers();
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Customer: " + customers.get(i).getName() + "[" + (i + 1) + "]");
            if (printTransactions) {
                ArrayList<Double> transactions = customers.get(i).getTransactions();
                System.out.println("Transactions");
                for (int j = 0; j < transactions.size(); j++) {
                    System.out.println("[" + (j + 1) + "] Amount " + transactions.get(j));
                }
            }
        }
        return true;
    }



}
