package contacts.phone_book.states;

import contacts.phone_book.PhoneBook;

public abstract class FunctionalState {

    protected PhoneBook book;
    protected FunctionalState previousState;

    public FunctionalState(FunctionalState previousState, PhoneBook book) {
        System.out.println();
        this.previousState = previousState;
        this.book = book;
    }

    public abstract void showAvailableActions();

    public abstract String[] getAvailableActions();

    public abstract boolean executeAction(String action);

    protected boolean isActionValid(String action) {
        for (String str : getAvailableActions()) {
            if (action.matches(str)) {
                return true;
            }
        }

        return false;
    }

    protected void listDialog() {
        for (int i = 0; i < book.size(); i++) {
            System.out.println((i + 1) + ". " + book.get(i));
        }
    }
}
