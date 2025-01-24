package com.bookingsystem.model;

public class User {
    private final String userName;
    private final int userAge;
    private final String userContact;
    private final String address;

    public User(String userName, int userAge, String userContact, String address) {
        this.userName = userName;
        this.userAge = userAge;
        this.userContact = userContact;
        this.address = address;
    }

    // Getters for user information
    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserContact() {
        return userContact;
    }

    public String getAddress() {
        return address;
    }
}
