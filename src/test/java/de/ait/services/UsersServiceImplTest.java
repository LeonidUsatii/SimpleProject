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
        List<String> expected = Arrays.asList()
    }

    @Test
    void getLastNameOfMostAging() {
    }

    @Test
    void getAverageAgeOfUsers() {
    }

    @Test
    void getAgeOfTallestPerson() {
    }

    @Test
    void getNameAndSurnameOfShortestPerson() {
    }
}