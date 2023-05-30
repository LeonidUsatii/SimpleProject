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
        UsersService usersService = new UsersServiceImpl(usersRepository);

        while (true) {
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");
            System.out.println("3. Сохранить нового пользователя");
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого человека");
            System.out.println("6. Вывести имя и фамилию самого низкого человека");
            System.out.println("7. Удалить пользователя по фамилии");
            System.out.println("8. Обновить данные о пользователе");
            System.out.println("0. Выход");

            String firstName = null;
            String lastName = null;
            int age = 0;
            double height = 0;

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
                    lastName = usersService.getLastNameOfMostAging();
                    System.out.println(lastName);
                    break;
                case 3:

                    System.out.println("Сохраняем нового пользователя");

                    System.out.println("Введите имя пользователя: ");

                    firstName = scanner.nextLine();
                    System.out.println("Введите фамилию пользователя: ");

                    lastName = scanner.nextLine();
                    System.out.println("Введите возраст пользователя: ");

                    age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите рост пользователя: ");

                    height = scanner.nextDouble();
                    scanner.nextLine();

                    usersService.getUser(firstName, lastName, age, height);
                    break;
                case 4:
                    System.out.println("Выводим средний возраст всех пользователей");
                    double averageAgeOfUsers = usersService.getAverageAgeOfUsers();
                    System.out.println(averageAgeOfUsers);
                    break;
                case 5:
                    System.out.println("Выводим возраст самого высокого человека");
                    int ageOfTallestPerson = usersService.getAgeOfTallestPerson();
                    System.out.println(ageOfTallestPerson);
                    break;
                case 6:
                    System.out.println("Выводим имя и фамилию самого низкого человека");
                    String nameAndSurnameOfShortestPerson = usersService.getNameAndSurnameOfShortestPerson();
                    System.out.println(nameAndSurnameOfShortestPerson);
                    break;
                case 7:
                    System.out.println("Удаляем пользователя по фамилии");
                    System.out.println("Введите фамилию пользователя");

                    lastName = scanner.nextLine();
                    usersService.deleteUser(lastName);
                    break;
                case 8:
                    System.out.println("Обновляем данные о пользователе");
                    System.out.println("Введите данные пользователя");
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }
}
