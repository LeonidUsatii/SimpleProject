package de.ait.services;

import de.ait.models.User;

import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();

    void getUser(String firstName, String lastName, int age, double height);

    double getAverageAgeOfUsers();

    int getAgeOfTallestPerson();

    String getNameAndSurnameOfShortestPerson();

    void deleteUser(String lastName);

    public void updateUser(String firstName, String lastName, int age, double height);

}