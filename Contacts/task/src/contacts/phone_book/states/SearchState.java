package contacts.phone_book.states;

import contacts.phone_book.PhoneBook;
import contacts.records.Record;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class SearchState extends FunctionalState {
    private ArrayList<Record> searchResults;

    public SearchState(FunctionalState previousState, PhoneBook book) {
        super(previousState, book);
        search();
    }

    private void search() {
        searchResults = new ArrayList<>();
        System.out.println("Enter search query:");
        Scanner scanner = new Scanner(System.in);
        getSearchResults(scanner.nextLine());
        showSearchResults();
    }

    private void showSearchResults() {
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println((i + 1) + ". " + searchResults.get(i));
        }
    }

    private void getSearchResults(String query) {
        ArrayList<Record> records = book.getRecords();
        for (Record record : records) {
            if (record.getInfo().toLowerCase(Locale.ROOT).contains(query.toLowerCase(Locale.ROOT))) {
                searchResults.add(record);
            }
        }
    }

    @Override
    public void showAvailableActions() {
        System.out.println("[search] Enter action ([number], back, again):");
    }

    @Override
    public String[] getAvailableActions() {
        return new String[] {"\\d+", "back", "again"};
    }

    @Override
    public boolean executeAction(String action) {
        if (!isActionValid(action)) {
            return false;
        }

        if (action.matches("\\d+")) {
            book.changeState(new RecordViewState(this, book, searchResults.get(Integer.parseInt(action) - 1)));
        } else {
            switch (action) {
                case "back":
                    book.changeState(previousState);
                    break;
                case "again":
                    search();
                    break;
            }
        }

        return true;
    }
}
