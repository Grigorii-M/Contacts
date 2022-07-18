package contacts.records;

import java.time.LocalDateTime;
import java.util.Scanner;

public abstract class Record {
    protected String phoneNumber;
    protected String name;

    private final LocalDateTime timeCreated;
    private LocalDateTime timeLastEdit;

    public Record(String phoneNumber, String name) {
        setPhoneNumber(phoneNumber);
        this.name = name;
        timeCreated = LocalDateTime.now();
        timeLastEdit = LocalDateTime.now();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("(^[\\d\\w]+$)|(^\\+?[\\d\\w]{1,}([ -][\\d\\w]{2,})*$)|(^\\+?\\([\\d\\w]{2,}\\)([ -][\\d\\w]{2,})*$)|(^\\+?[\\d\\w]{1,}[ -]\\([\\d\\w]{2,}\\)([ -][\\d\\w]{2,})*$)")) {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        } else {
            this.phoneNumber = phoneNumber;
            updateTimeLastEdit();
        }
    }

    public void setName(String name) {
        this.name = name;
        updateTimeLastEdit();
    }

    protected void updateTimeLastEdit() {
        timeLastEdit = LocalDateTime.now();
    }

    public String getPhoneNumber() {
        if (phoneNumber.isEmpty()) {
            return "[no data]";
        }
        return phoneNumber;
    }

    public String getName() {
        if (name.isEmpty()) {
            return "[no data]";
        }
        return name;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    public abstract String getInfo();

    public abstract void showEditDialog();
}