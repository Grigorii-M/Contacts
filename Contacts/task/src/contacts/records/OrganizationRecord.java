package contacts.records;

import java.util.Scanner;

public class OrganizationRecord extends Record {

    private String address;

    public OrganizationRecord(String phoneNumber, String name, String address) {
        super(phoneNumber, name);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
        updateTimeLastEdit();
    }

    public String getAddress() {
        if (address.isEmpty()) {
            return "[no data]";
        }
        return address;
    }

    @Override
    public String getInfo() {
        return "Organization name: " + getName() +
                "\nAddress: " + getAddress() +
                "\nNumber: " + getPhoneNumber() +
                "\nTime created: " + getTimeCreated().toString() +
                "\nTime last edit: " + getTimeLastEdit().toString();
    }

    @Override
    public void showEditDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a field (name, address, number):");
        String choice = scanner.nextLine();
        switch (choice) {
            case "name":
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                this.setName(name);
                break;
            case "address":
                System.out.println("Enter address:");
                String address = scanner.nextLine();
                this.setAddress(address);
                break;
            case "number":
                System.out.println("Enter number:");
                String number = scanner.nextLine();
                this.setPhoneNumber(number);
                break;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
