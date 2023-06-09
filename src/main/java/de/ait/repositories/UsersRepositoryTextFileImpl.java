package de.ait.repositories;

import de.ait.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryTextFileImpl implements UsersRepository {

    private String fileName;

    public UsersRepositoryTextFileImpl(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line = bufferedReader.readLine();

            while (line != null) {
                User user = parseLine(line);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

        return users;
    }

    @Override
    public void writeUser(User user) {

        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(fileName, true));) {

            String userName = "";

            userName = user.getFirstName() + "|" + user.getLastName()
                    + "|" + user.getAge() + "|" + user.getHeight();
            bufferedWriter.write(userName);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }

    }

    private static User parseLine(String line) {
        String[] parsed = line.split("\\|");
        String firstName = parsed[0];
        String lastName = parsed[1];
        int age = Integer.parseInt(parsed[2]);
        double height = Double.parseDouble(parsed[3]);
        return new User(firstName, lastName, age, height);
    }

    @Override
    public List<String> getNewList(String lastName) {
        List<String> names = new ArrayList<>();
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();

            while (line != null) {
                if (!line.contains(lastName)) {
                    names.add(line);
                    line = bufferedReader.readLine();
                } else {
                    line = bufferedReader.readLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
        return names;
    }

    @Override
    public void deleteUser(String lastName) {
        List<String> names;
        names = getNewList(lastName);

        try (PrintWriter pw = new PrintWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter
                     (new FileWriter(fileName, true));) {

            for (String name : names) {
                bufferedWriter.write(name);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
    }

    @Override
    public void updateUser(User updateUser) {

        List<User> users = findAll();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLastName().equals(updateUser.getLastName())) {
                users.set(i, updateUser);
            }
        }

        try (PrintWriter pw = new PrintWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter
                     (new FileWriter(fileName, true));) {

            String userName = "";
            for (User user : users) {
                userName = user.getFirstName() + "|" + user.getLastName()
                        + "|" + user.getAge() + "|" + user.getHeight();
                bufferedWriter.write(userName);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            System.err.println("Произошла ошибка");
        }
    }


}
