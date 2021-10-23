package models;

public class User {
    String name;
    String lastName;
    String email;
    String password;
    String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User withPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;
    }
}
