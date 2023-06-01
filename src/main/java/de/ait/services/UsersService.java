package de.ait.services;

import de.ait.models.User;

import java.util.List;

public interface UsersService {
    List<String> getNames();
    String getLastNameOfMostAging();
    void getUser(String firstName, String lastName, int age, double height);
    List<String> getNewList(String name);
    double getAverageAgeOfUsers();
    int getAgeOfTallestPerson();
    String getNameAndSurnameOfShortestPerson();
    void deleteUser(String lastName);
    List<User> getUpdateListUser(User user);
    void updateUser(String firstName, String lastName, int age, double height);

}