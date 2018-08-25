import java.util.LinkedList;

import java.io.Serializable;
import java.util.Scanner;

class Waitlist implements Serializable {
    private LinkedList wl;

    Waitlist() {
        wl = new LinkedList();
    }

    void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("   Adding Customer: ");
        System.out.println("\tCustomer first name: ");
        String f = scanner.nextLine();
        System.out.println("\tCustomer last name: ");
        String l = scanner.nextLine();
        System.out.println("\tCustomer phone number: ");
        String p = scanner.nextLine();

        Customer c = new Customer(f,l,p);

        wl.add(wl.size(), c);
    }

    Object nextCustomer() {
        return wl.getFirst();
    }

    void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Phone number to remove from wait list: ");
        String s = scanner.nextLine();
        Object x = getCustomer(s);
        if (x == null) {
            System.out.println("!! Not Found !!");
        } else {
            wl.remove(x);
        }
    }

    void displayNumOnWaitList(int j) {
        for (int i = 0; i < j; i++) {
            Object x = wl.get(i);
            ((Customer) x).shortDisplay();
        }
    }

    Object getCustomer(String s) {
        for (int i = 0; i < wl.size(); i++) {
            Object x = wl.get(i);
            if (((Customer) x).getPhoneNumber().equals(s))
                return x;
        }
        return null;
    }

    void shortDisplayWaitList() {
        if (wl.size() == 0) {
            System.out.println("Wait list empty");
        } else {
            for (int i = 0; i < wl.size(); i++) {
                Object x = wl.get(i);
                ((Customer) x).shortDisplay();
            }
        }
    }

    void displayWaitList() {
        if (wl.size() == 0) {
            System.out.println("Wait list empty :)");
        } else {
            System.out.println("\t  Customers on WaitList:");
            System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~");
            for (int i = 0; i < wl.size(); i++) {
                Object x = wl.get(i);
                ((Customer) x).display();
            }
        }
    }
}
