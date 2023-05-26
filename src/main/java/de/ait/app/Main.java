package de.ait.app;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import de.ait.services.UsersService;
import de.ait.services.UsersServiceImpl;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsersRepository usersRepository = new UsersRepositoryTextFileImpl("users.txt");
        UsersRepository testUserRepository = new UsersRepositoryListImpl();
        UsersService usersService = new UsersServiceImpl(usersRepository);

        while (true) {
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");
            System.out.println("3. Сохранить нового пользователя");
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого человека");
            System.out.println("6. Вывести имя и фамилию самого низкого человека");

            System.out.println("0. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    System.out.println("Выводим имена пользователей...");
                    List<String> names = usersService.getNames();

                    for (String name : names) {
                        System.out.println(name);
                    }
                    break;
                case 2:
                    System.out.println("Выводим самого взрослого пользователя");
                    String lastName = usersService.getLastNameOfMostAging();
                    System.out.println(lastName);
                    break;
                case 3:
                    System.out.println("Сохраняем нового пользователя");
                    List<User> users = usersService.getListUserFromConsole(scanner);
                    usersRepository.writeUserToFile(users);
                    break;
                case 4:
                    System.out.println("Выводим средний возраст всех пользователей");
                    double averageAgeOfUsers = usersService.getAverageAgeOfUsers();
                    System.out.println(averageAgeOfUsers);
                    break;
                case 5:
                    System.out.println("Выводим возраст самого высокого человека");
                    //int ageOfTallestPerson = usersService.getAgeOfTallestPerson();
                    //System.out.println(ageOfTallestPerson);
                    break;
                case 6:
                    System.out.println("Выводим имя и фамилию самого низкого человека");
                    String nameAndSurnameOfShortestPerson = usersService.getNameAndSurnameOfShortestPerson();
                    System.out.println(nameAndSurnameOfShortestPerson);
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }

    public static User addUserFromConsole(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите имя пользователя: ");
                String firstName = scanner.nextLine();

                if (firstName.length() == 0) {
                    throw new NullPointerException("Введите корректные данные");
                }
                System.out.println("Введите фамилию пользователя: ");

                String lastName = scanner.nextLine();
                if (lastName.length() == 0) {
                    throw new NullPointerException("Введите корректные данные");
                }
                System.out.println("Введите возраст пользователя: ");

                int age = scanner.nextInt();
                if (age <= 0 || age > 120) {
                    throw new NullPointerException("Введите корректные данные");
                }
                scanner.nextLine();
                System.out.println("Введите рост пользователя: ");
                double height = scanner.nextDouble();

                if (height <= 0 || height > 200) {
                    throw new NullPointerException("Введите корректные данные");
                }
                scanner.nextLine();
                return new User(firstName, lastName, age, height);

            } catch (NullPointerException e) {
                System.out.println("Ошибка - " + e.getMessage());
            }
        }

    }
}
