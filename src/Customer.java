import java.io.Serializable;

class Customer implements Serializable {
    private String firstName, lastName, phoneNumber;

    Customer(String f, String l, String p) {
        firstName = f;
        lastName = l;
        phoneNumber = p;
    }

    void display() {
        System.out.println("\t\tFirst Name: " + firstName);
        System.out.println("\t\tLast Name: " + lastName);
        System.out.println("\t\tPhone Number: " + phoneNumber);
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void shortDisplay() {
        System.out.println("\tName: " + firstName + " " + lastName);
        System.out.println("\tPhone number: " + phoneNumber);
    }
}
