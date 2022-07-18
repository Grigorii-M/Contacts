package contacts;
import contacts.phone_book.PhoneBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook book = new PhoneBook();

        String action;
        do {
            if (book.shouldExit()) {
                break;
            }
            book.showAvailableActions();
            action = scanner.nextLine();
        } while (book.executeAction(action));
    }
}