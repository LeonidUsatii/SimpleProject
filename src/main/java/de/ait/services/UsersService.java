package de.ait.services;

import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();

    void getUser(String firstName, String lastName, int age, double height);

    double getAverageAgeOfUsers();

    int getAgeOfTallestPerson();

    String getNameAndSurnameOfShortestPerson();

    void deleteUser(String lastName);

}