package de.ait.repositories;

import de.ait.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    void writeUser(User user);
    List<String> getNamesFromFile(String name);
    void deleteUser(String lastName);
    List<User> getUpdateListUser(User user);
    public void updateUser(User updateUser);
}

