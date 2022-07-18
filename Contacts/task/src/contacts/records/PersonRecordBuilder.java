package contacts.records;

public class PersonRecordBuilder extends RecordBuilder {

    private String surname;
    private String gender;
    private String birthDate;

    public PersonRecord build() {
        return new PersonRecord(phoneNumber, name, surname, gender, birthDate);
    }

    public void addSurname(String surname) {
        if (surname.isEmpty()) {
            System.out.println("Bad surname!");
        }
        this.surname = surname;
    }

    public void addGender(String gender) {
        if (gender.isEmpty()) {
            System.out.println("Bad gender!");
        }
        this.gender = gender;
    }

    public void addBirthDate(String birthDate) {
        if (birthDate.isEmpty()) {
            System.out.println("Bad birth date!");
        }
        this.birthDate = birthDate;
    }
}
