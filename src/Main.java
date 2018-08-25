public class Main {

    public static void main(String[] args) {
        Inventory i = new Inventory();
        int path = i.open();
        if (path == 0) {
            System.out.println("Inventory loaded");
            System.out.println("Initializing Controls...\n\n");
            Controller c = new Controller();
            c.menu(i);
        } else if (path == 1) {
            System.out.println("Inventory not loaded");
            Controller c = new Controller();
            c.menu(i);
        } else {
            System.out.println("Unknown IO Error");
            System.out.println("Program Terminating...");
        }

        //save inventory just in case user forgets
        i.save();
    }
}
