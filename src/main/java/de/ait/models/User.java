package de.ait.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private double height;

    public User(String firstName, String lastName, int age, double height) {

            if (firstName!= null) {
                this.firstName = firstName;
            } else {
                this.firstName = "NO_NAME";
            }

            if (lastName!= null) {
                this.lastName = firstName;
            } else {
                this.lastName = "NO_NAME";
            }

            if (age > 0 && age < 120) {
                this.age = age;
            } else {
                this.age = 33;
                System.err.println("Возраст отредактирован");
            }

            if (height > 0 && height <  200) {
                this.height = height;
            } else {
                this.height = 178;
                System.err.println("Рост отредактирован");
            }

    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public int getAge() {

        return age;
    }

    public double getHeight() {

        return height;
    }


}
