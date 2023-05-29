package de.ait.services;

import de.ait.models.User;

import java.util.List;

import java.util.Scanner;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();

    List<User> getListUserFromConsole(Scanner scanner);

    double getAverageAgeOfUsers();

    int getAgeOfTallestPerson();

    String getNameAndSurnameOfShortestPerson();

    String getUsernameToDelete();

}