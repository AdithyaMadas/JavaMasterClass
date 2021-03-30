import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer findCustomer(String name) {
        for (Customer i : customers) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }

    public boolean newCustomer(String name, double transaction) {
        if (findCustomer(name) == null) {
            Customer customer = new Customer(name, transaction);
            customers.add(customer);
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String name, double transaction) {
        Customer cust = findCustomer(name);
        if (cust != null) {
            cust.addTransaction(transaction);
            return true;
        }
        return false;
    }
}
