package contacts.phone_book;

import contacts.phone_book.states.FunctionalState;
import contacts.phone_book.states.MenuState;
import contacts.records.Record;

import java.util.ArrayList;

public class PhoneBook {
    private static final ArrayList<Record> records = new ArrayList<>();

    private FunctionalState state;
    private boolean shouldExit = false;

    public PhoneBook() {
        state = new MenuState(null, this);
    }

    public void changeState(FunctionalState state) {
        this.state = state;
    }

    public void showAvailableActions() {
        state.showAvailableActions();
    }

    public String[] getAvailableActions() {
        return state.getAvailableActions();
    }

    public boolean executeAction(String action) {
        return state.executeAction(action);
    }

    public boolean isEmpty() {
        return records.isEmpty();
    }

    public Record get(int index) {
        return records.get(index);
    }

    public int size() {
        return records.size();
    }

    public void add(Record record) {
        records.add(record);
    }

    public boolean shouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    public void removeRecord(Record record) {
        records.remove(record);
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public String count() {
        return records.size() + " records";
    }
}
