import java.io.Serializable;
import java.util.Scanner;

public class StockItem implements Serializable {
    private String title;
    private int have, want, wlCount;
    private Waitlist wl;

    StockItem(String t, int h) {
        title = t;
        have = h;
        wl = new Waitlist();
        wlCount = 0;
    }

    void addCustomerToWaitList() {
        wl.addCustomer();
        ++want;
    }

    int getWlCount() {
        return wlCount;
    }

    int getHave() {
        return have;
    }

    void displayNextCustomer() {
        Object cust = wl.nextCustomer();
        ((Customer) cust).display();
    }

    String getTitle() {
        return title;
    }

    void sellToWaitList() {
        System.out.println("Is customer on waitlist? y/n");
        wl.shortDisplayWaitList();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("y") || input.equals("Y")) {
            removeCustomer();
            --have;
        }
        else {
            --have;
        }
    }

    void removeCustomer() {
        wl.deleteCustomer();
        wlCount-=1;
        want-=1;
    }

    void sellItem() {
        if (have > 0) {
            if (wlCount > 0)
                sellToWaitList();
            else
                --have;
        } else {
            addCustomerToWaitList();
            wlCount+=1;
        }
    }

    void deliver(int h) {
        have += h;
    }

    void changeTitle(String s) {
        title = s;
    }

    void changeHave(int h) {
        have = h;
    }

    void changeWant(int w) {
        want = w;
    }
    void displayItem() {
        System.out.println("--------------------------");
        System.out.println("DVD Title: " + title);
        System.out.println("No. in Stock: " + have);
        System.out.println("Demand: " + want);
        wl.displayWaitList();
    }

}
