package de.ait.repositories;

import de.ait.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    void writeUserToFile(List<User> list);
    List<String> getNamesFromFile(String name);
    void removeUserFromFile(String fileName);
    List<User> getUpdateListUser(List<User> updatelist);
    void updateUsersToFile(List<User> updatelist);
}

