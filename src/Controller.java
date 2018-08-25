import java.util.Scanner;

public class Controller {
    private void greeting() {
        System.out.println("Welcome to DVD Inventory Management");
        System.out.println("To Continue press enter...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
    private void commandList() {
        System.out.println("Commands:\n" +
                "\th : help\n" +
                "\ti : inquire\n" +
                "\tl : list\n" +
                "\ta : add\n" +
                "\tm : modify\n" +
                "\td : delivery\n" +
                "\to : order\n" +
                "\tr : return\n" +
                "\ts : sell\n" +
                "\tsa : save\n" +
                "\tda : delete inventory\n" +
                "\tq : quit\n");
    }
    private void confirmDelete(Inventory i) {
        System.out.println("Are you sure you want to delete the inventory?");
        System.out.println("Warning!! This cannot be undone.");
        System.out.println("y/n");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("y") || input.equals("Y")) {
            i.deleteInventory();
            System.out.println("##Inventory DELETED##");
        }
        else {
            System.out.println("Inventory not deleted.");
        }
    }
    public void menu(Inventory i) {
        Scanner scanner = new Scanner(System.in);
        greeting();
        commandList();

        boolean sentinel = true;
        while (sentinel == true) {
            String input = scanner.nextLine();
            switch (input) {
                case "":
                    commandList();
                    break;
                case "h":
                    displayHelp();
                    break;
                case "d":
                    i.delivery();
                    break;
                case "a":
                    i.addItem();
                    break;
                case "l":
                    i.display();
                    break;
                case "s":
                    i.sell();
                    break;
                case "i":
                    i.displayItem();
                    break;
                case "sa":
                    i.save();
                    break;
                case "da":
                    confirmDelete(i);
                    break;
                case "m":
                    i.modify();
                    break;
                case "o":
                    i.order();
                    break;
                case "r":
                    i.ret();
                    break;
                case "q":
                    System.out.println("GOODBYE!");
                    return;
                default:
                    System.out.println("Try again.");
                    commandList();
                    break;
            }
        }
    }

    private void displayHelp() {
        System.out.println(
                " _____                     _                      ___  ___\n" +
                        "|_   _|                   | |                     |  \\/  |\n" +
                        "  | | _ ____   _____ _ __ | |_ ___  _ __ _   _    | .  . | __ _ _ __   __ _  __ _  ___ _ __\n" +
                        "  | || '_ \\ \\ / / _ \\ '_ \\| __/ _ \\| '__| | | |   | |\\/| |/ _` | '_ \\ / _` |/ _` |/ _ \\ '__|\n" +
                        " _| || | | \\ V /  __/ | | | || (_) | |  | |_| |   | |  | | (_| | | | | (_| | (_| |  __/ |\n" +
                        " \\___/_| |_|\\_/ \\___|_| |_|\\__\\___/|_|   \\__, |   \\_|  |_/\\__,_|_| |_|\\__,_|\\__, |\\___|_|\n" +
                        "                                          __/ |                              __/ |\n" +
                        "                                         |___/                              |___/\n" +
                        "\n" +
                        "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                        "                                                                                             \n" +
                        "Help/Commands:\n" +
                        "\n" +
                        "\th          | (help)        |    Provide a summary of the available commands (this listing).\n" +
                        "\ti          | (inquire)     |    Display the inventory info for a specified title.\n" +
                        "\tl          | (list)        |    List the entire inventory (Alphabetical).\n" +
                        "\ta          | (add)         |    Add a new title to the inventory. Prompts for want value.\n" +
                        "\tm          | (modify)      |    Modify the want value for a specified title.\n" +
                        "\td          | (delivery)    |    Take DVD shipment delivery. Specify addition of large stock.\n" +
                        "\to          | (order)       |    Write a purchase order for additional DVDs\n" +
                        "\tr          | (return)      |    Write a return order\n" +
                        "\ts          | (sell)        |    Decrease the count for a specified title by 1. If the\n" +
                        "\t\t        \t\t\t\t\ttitle is sold out, put a name on the waitlist for the\n" +
                        "\t\t\t    \t\t\t\t\ttitle.\n" +
                        "\tq          | (quit)        |    Save the inventory and waitlists in a file and quit.");
    }
}
