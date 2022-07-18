package contacts.phone_book.states;

import contacts.phone_book.PhoneBook;

public class ListState extends FunctionalState {
    public ListState(FunctionalState previousState, PhoneBook book) {
        super(previousState, book);
        listDialog();
    }

    @Override
    public void showAvailableActions() {
        System.out.println("[list] Enter action ([number], back):");
    }

    @Override
    public String[] getAvailableActions() {
        return new String[] {"\\d+", "back"};
    }

    @Override
    public boolean executeAction(String action) {
        if (!isActionValid(action)) {
            return false;
        }

        if (action.matches("\\d+")) {
            book.changeState(new RecordViewState(this, book, book.get(Integer.parseInt(action) - 1)));
        } else {
            book.changeState(previousState);
        }

        return true;
    }
}
