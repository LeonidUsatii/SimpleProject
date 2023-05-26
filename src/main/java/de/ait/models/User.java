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
        try {
            if (firstName.length() == 0) {
                throw new NullPointerException("Введите корректные данные");
            } else {
                this.firstName = firstName;
            }
            if (lastName.length() == 0) {
                throw new NullPointerException("Введите корректные данные");
            } else {
                this.lastName = lastName;
            }
            if (age <= 0 || age > 120) {
                throw new NullPointerException("Введите корректные данные");
            } else {
                this.age = age;
            }
            if (height <= 0 || height > 200) {
                throw new NullPointerException("Введите корректные данные");
            } else {
                this.height = height;
            }
        } catch (NullPointerException e) {
            System.out.println("Ошибка - " + e.getMessage());
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
