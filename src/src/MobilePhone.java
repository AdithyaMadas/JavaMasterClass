import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    List<Contact> myContacts;

   /* public static void main(String[] args) {
        MobilePhone mobilePhone = new MobilePhone("123");
        System.out.println(mobilePhone.addNewContact(Contact.getContact("asd", "123")));
        System.out.println(mobilePhone.addNewContact(Contact.getContact("qwe", "234")));
        System.out.println(mobilePhone.updateContact(Contact.getContact("asd","123"),Contact.getContact("ert","234")));
        System.out.println(mobilePhone.addNewContact(Contact.getContact("asd", "345")));
    }*/

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    private int findContact(Contact contact) {
        int w = 0;
        for (Contact i : myContacts) {
            if (i.getName().equalsIgnoreCase(contact.getName())) {
                return w;
            }
            w++;
        }
        return -1;
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) != -1) {
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact old, Contact newOne) {
        if (findContact(old) == -1) {
            return false;
        }
        int i = findContact(old);
        removeContact(old);
        addNewContact(newOne);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact) == -1) {
            return false;
        }
        myContacts.remove(findContact(contact));
        return true;
    }

    public Contact queryContact(String name) {
        int i = findContact(name);
        if (i == -1) {
            return null;
        }
        return myContacts.get(i);
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println(i+1+": "+myContacts.get(i).getName()+" -> "+myContacts.get(i).getPhoneNumber());
        }
    }
}
