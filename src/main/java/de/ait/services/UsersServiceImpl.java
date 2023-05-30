package de.ait.services;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;

import java.util.*;

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {

        this.usersRepository = usersRepository;
    }

    @Override
    public List<String> getNames() {
        List<User> users = usersRepository.findAll();
        List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getFirstName());
        }

        return names;
    }

    @Override
    public String getLastNameOfMostAging() {
        List<User> users = usersRepository.findAll();
        User maxAge = users.get(0);

        for (User user : users) {
            if (user.getAge() > maxAge.getAge()) {
                maxAge = user;
            }
        }
        return maxAge.getLastName();
    }

    @Override
    public void getUser(String firstName, String lastName, int age, double height) {
       usersRepository.writeUser(new User(firstName, lastName, age, height));
    }

    @Override
    public double getAverageAgeOfUsers() {
        List<User> users = usersRepository.findAll();
        double averageAgeOfUsers = 0;

        for (User user : users) {
            averageAgeOfUsers += user.getAge();
        }
        return Math.round(averageAgeOfUsers / users.size());
    }


       @Override
   public int getAgeOfTallestPerson() {
           List<User> users = usersRepository.findAll();
           User maxTallest = users.get(0);
           for (User user : users) {
            if (user.getHeight() > maxTallest.getHeight()) {
                maxTallest = user;
            }
        }
        return maxTallest.getAge();
    }


    @Override
    public String getNameAndSurnameOfShortestPerson() {
        List<User> users = usersRepository.findAll();

        User minTallest = users.get(0);

        for (User user : users) {
            if (user.getHeight() < minTallest.getHeight()) {
                minTallest = user;
            }
        }
        return minTallest.getFirstName() + " " + minTallest.getLastName();
    }

    @Override
    public String getUsernameToDelete() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}