package contacts.phone_book.states;

import contacts.phone_book.PhoneBook;
import contacts.records.Record;

public class RecordViewState extends FunctionalState {

    private final Record record;

    public RecordViewState(FunctionalState previousState, PhoneBook book, Record record) {
        super(previousState, book);
        this.record = record;
        System.out.println(record.getInfo());
    }

    @Override
    public void showAvailableActions() {
        System.out.println("[record] Enter action (edit, delete, menu):");
    }

    @Override
    public String[] getAvailableActions() {
        return new String[] {"edit", "delete", "menu"};
    }

    @Override
    public boolean executeAction(String action) {
        if (!isActionValid(action)) {
            return false;
        }

        switch (action) {
            case "edit":
                editDialog();
                break;
            case "delete":
                book.removeRecord(record);
                book.changeState(new MenuState(this, book));
                break;
            case "menu":
                book.changeState(new MenuState(this, book));
                break;
        }

        return true;
    }

    private void editDialog() {
        record.showEditDialog();
    }
}
