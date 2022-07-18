package contacts.records;

import java.util.Scanner;

public class PersonRecord extends Record {

    private String surname;
    private String gender;
    private String dateOfBirth;

    public PersonRecord(String phoneNumber, String name, String surname, String gender, String dateOfBirth) {
        super(phoneNumber, name);
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    private void setSurname(String surname) {
        this.surname = surname;
        updateTimeLastEdit();
    }

    private void setGender(String gender) {
        this.gender = gender;
        updateTimeLastEdit();
    }

    private void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        updateTimeLastEdit();
    }

    public String getSurname() {
        if (surname.isEmpty()) {
            return "[no data]";
        }
        return surname;
    }

    public String getGender() {
        if (gender.isEmpty()) {
            return "[no data]";
        }
        return gender;
    }

    public String getDateOfBirth() {
        if (dateOfBirth.isEmpty()) {
            return "[no data]";
        }
        return dateOfBirth;
    }

    @Override
    public String getInfo() {
        return "Name: " + getName() +
                "\nSurname: " + getSurname() +
                "\nBirth date: " + getDateOfBirth() +
                "\nGender: " + getGender() +
                "\nNumber: " + getPhoneNumber() +
                "\nTime created: " + getTimeCreated().toString() +
                "\nTime last edit: " + getTimeLastEdit().toString();
    }

    @Override
    public void showEditDialog() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a field (name, surname, birth, gender, number):");
        String choice = scanner.nextLine();
        switch (choice) {
            case "name":
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                this.setName(name);
                break;
            case "surname":
                System.out.println("Enter surname:");
                String surname = scanner.nextLine();
                this.setSurname(surname);
                break;
            case "birth":
                System.out.println("Enter birth:");
                String birth = scanner.nextLine();
                this.setDateOfBirth(birth);
                break;
            case "gender":
                System.out.println("Enter gender:");
                String gender = scanner.nextLine();
                this.setGender(gender);
                break;
            case "number":
                System.out.println("Enter number:");
                String number = scanner.nextLine();
                this.setPhoneNumber(number);
                break;
        }
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
