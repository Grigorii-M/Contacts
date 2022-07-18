package contacts.phone_book.states;

import contacts.phone_book.PhoneBook;
import contacts.records.OrganizationRecordBuilder;
import contacts.records.PersonRecordBuilder;

import java.util.Scanner;

public class MenuState extends FunctionalState {
    public MenuState(FunctionalState previousState, PhoneBook book) {
        super(previousState, book);
    }

    @Override
    public void showAvailableActions() {
        System.out.println("[menu] Enter action (add, list, search, count, exit):");
    }

    @Override
    public String[] getAvailableActions() {
        return new String[] {"add", "list", "search", "count", "exit"};
    }

    @Override
    public boolean executeAction(String action) {
        if (!isActionValid(action)) {
            return false;
        }

        switch (action) {
            case "add":
                addDialog();
                break;
            case "list":
                book.changeState(new ListState(this, book));
                break;
            case "count":
                System.out.println(book.count());
                break;
            case "search":
                book.changeState(new SearchState(this, book));
                break;
            case "exit":
                book.setShouldExit(true);
                break;
        }

        return true;
    }

    private void addDialog()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type (person, organization):");
        String type = scanner.nextLine();
        if (type.equals("person")) {
            PersonRecordBuilder personRecordBuilder = new PersonRecordBuilder();

            System.out.println("Enter the name:");
            personRecordBuilder.addName(scanner.nextLine());

            System.out.println("Enter the surname:");
            personRecordBuilder.addSurname(scanner.nextLine());

            System.out.println("Enter the birth date:");
            personRecordBuilder.addBirthDate(scanner.nextLine());

            System.out.println("Enter the gender:");
            personRecordBuilder.addGender(scanner.nextLine());

            System.out.println("Enter the number:");
            personRecordBuilder.addPhoneNumber(scanner.nextLine());

            book.add(personRecordBuilder.build());
            System.out.println("The record added.");
        } else if (type.equals("organization")) {
            OrganizationRecordBuilder organizationRecordBuilder = new OrganizationRecordBuilder();

            System.out.println("Enter the name:");
            organizationRecordBuilder.addName(scanner.nextLine());

            System.out.println("Enter the address:");
            organizationRecordBuilder.addAddress(scanner.nextLine());

            System.out.println("Enter the number:");
            organizationRecordBuilder.addPhoneNumber(scanner.nextLine());

            book.add(organizationRecordBuilder.build());
            System.out.println("The record added.");
        }
    }
}
