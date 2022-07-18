package contacts.records;

public abstract class RecordBuilder {

    protected String phoneNumber;
    protected String name;

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addName(String name) {
        if (name.isEmpty()) {
            System.out.println("Bad name!");
        }
        this.name = name;
    }

    public abstract Record build();
}
