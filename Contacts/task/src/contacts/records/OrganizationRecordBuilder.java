package contacts.records;

public class OrganizationRecordBuilder extends RecordBuilder {

    private String address;

    @Override
    public Record build() {
        return new OrganizationRecord(phoneNumber, name, address);
    }

    public void addAddress(String address) {
        if (address.isEmpty()) {
            System.out.println("Bad address!");
        }
        this.address = address;
    }
}
