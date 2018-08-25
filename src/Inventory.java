import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class Inventory implements Serializable {
    private LinkedList inventory = null;

    public Inventory() {
        inventory = new LinkedList<>();
    }

    public void modify() {
        System.out.println("Which title would you like to modify?");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Object x = getByTitle(s);
        if (x == null) {
            System.out.println("!! Not Found !!");
        } else {
            ((StockItem) x).displayItem();
            modifyTitle((StockItem) x);
        }
    }

    private void modifyTitle(StockItem x) {
        System.out.println("-------------------------------------");
        System.out.println("Which value would you like to modify?");
        System.out.println("t : title");
        System.out.println("h : have");
        //System.out.println("w : want");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s) {
            case "t":
                System.out.println("Enter a title: ");
                s = scanner.nextLine();
                x.changeTitle(s);
                break;
            case "h":
                System.out.println("Enter a new have value: ");
                int scan = scanner.nextInt();
                x.changeHave(scan);
                return;
            case "w":
                System.out.println("Enter a new want value: ");
                int sn = scanner.nextInt();
                x.changeWant(sn);
                return;
            default:
                System.out.println("Try again.");
                break;
        }
    }

    public void ret() {
        System.out.println("Which title is to be returned?");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Object x = getByTitle(s);
        if (x == null) {
            System.out.println("!! Not Found !!");
        } else {
            ((StockItem) x).deliver(1);
        }
    }

    public void order() {
        System.out.println("Create order list? y/n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = 0;
        if (input.equals("y") || input.equals("Y")) {
            for (int i = 0; i < inventory.size(); i++) {
                Object x = inventory.get(i);
                if (((StockItem) x).getWlCount() > 0) {
                    System.out.println("Title: " + ((StockItem) x).getTitle() + " | Stock: " +((StockItem) x).getHave() + " | Wait List: " + ((StockItem) x).getWlCount());
                    count +=1;
                }
            }
            if (count == 0) {
                System.out.println("No one on wait list, nothing to be ordered.");
            }
        }
        else {
            System.out.println("Cancelled.");
        }
    }

    public void deleteInventory() {
        inventory = new LinkedList<>();
    }

    void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding Customer: ");
        System.out.println("\tDVD Title: ");
        String t = scanner.nextLine();
        System.out.println("\tNumber of Items: ");
        int h = scanner.nextInt();
        StockItem item = new StockItem(t,h);
        inventory.add(inventory.size(), item);
    }

    public void display() {
        System.out.println("\t:: Inventory :: ");
        for (int i = 0; i < inventory.size(); i++) {
            Object x = inventory.get(i);
            ((StockItem) x).displayItem();
        }
    }

    public void displayItem() {
        // display specific item
        System.out.println("Enter title to display: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Object x = getByTitle(s);
        if (x == null) {
            System.out.println("!! Not Found !!");
        } else {
            ((StockItem) x).displayItem();
        }
    }

    public void delivery() {
        System.out.println("Title to deliver: ");
        Scanner scanner = new Scanner(System.in);
        String titleDeliv = scanner.nextLine();
        System.out.println("Number to deliver: ");
        int stock = scanner.nextInt();

        Object x = getByTitle(titleDeliv);
        if (x == null)
            System.out.println("!! Not a valid title !!");
        else
            ((StockItem) x).deliver(stock);
    }

    public void sell() {
        System.out.println("Enter title to sell: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Object x = getByTitle(s);
        if (x == null) {
            System.out.println("!! Not Found !!");
        } else {
            ((StockItem) x).sellItem();
        }
    }

    Object getByTitle(String s) {
        for (int i = 0; i < inventory.size(); i++) {
            Object x = inventory.get(i);
            if (((StockItem) x).getTitle().equals(s))
                return x;
        }
        return null;
    }

    public int save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("inventory.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(inventory);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved inventory.ser");
            return 0;
        } catch (IOException i) {
            i.printStackTrace();
            return -1;
        }
    }

    public int open() {
        try {
            FileInputStream fileIn = new FileInputStream("inventory.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            inventory = (LinkedList) in.readObject();
            return 0;
        } catch (IOException i) {
            i.printStackTrace();
            return -1;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return 1;
        }
    }
}
