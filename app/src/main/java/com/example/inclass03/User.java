package com.example.inclass03;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    String gender,firstname,lastname;


    public User(String gender, String firstname, String lastname) {
        this.gender = gender;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
