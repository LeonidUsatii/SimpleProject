package de.ait.repositories;

import de.ait.models.User;

import java.util.List;

public interface UsersRepository {
    List<User> findAll();
    void writeUser(User user);
    List<String> getNewList(String name);
    void deleteUser(String lastName);
    void updateUser(User updateUser);
}

