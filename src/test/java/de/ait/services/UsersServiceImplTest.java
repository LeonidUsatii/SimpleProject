package de.ait.services;

import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import de.ait.repositories.UsersRepositoryTextFileImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class UsersServiceImplTest {
    private UsersServiceImpl usersService;
    @BeforeEach
    void setUp() {
        this.usersService = new UsersServiceImpl(new UsersRepositoryListImpl());
        }
    @Test
    void getNames() {
        List<String> actual = usersService.getNames();
        List<String> expected = Arrays.asList("Marsel", "Maxim", "Kirill");
        assertEquals(expected, actual);
    }

    @Test
    void getLastNameOfMostAging() {
        String expected = "Petrov";
        String actual = usersService.getLastNameOfMostAging();
        assertEquals(expected, actual);
    }

    @Test
    void getAverageAgeOfUsers() {
        double expected = 34.0;
        double actual = usersService.getAverageAgeOfUsers();
        assertEquals(expected, actual);
    }

    @Test
    void getAgeOfTallestPerson() {
        int expected = 55;
        int actual = usersService.getAgeOfTallestPerson();
        assertEquals(expected, actual);
    }

    @Test
    void getNameAndSurnameOfShortestPerson() {
        String expected = "Maxim Ivanov";
        String actual = usersService.getNameAndSurnameOfShortestPerson();
        assertEquals(expected, actual);
    }
}