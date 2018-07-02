package com.individual.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class UserCreation {
    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long accountNumber;

    public UserCreation(){}

    public UserCreation(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserFullName() {
        return firstName + " " + lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
