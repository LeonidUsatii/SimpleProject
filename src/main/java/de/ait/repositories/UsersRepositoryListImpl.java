package de.ait.repositories;

import de.ait.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryListImpl implements UsersRepository {
    @Override
    public List<User> findAll() {
        User user = new User("Marsel", "Sidikov", 29, 185);
        User user1 = new User("Maxim", "Ivanov", 19, 179);
        User user2 = new User("Kirill", "Petrov", 55, 190);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        return users;
    }

    @Override
    public void writeUserToFile(List<User> list) {

    }
}
