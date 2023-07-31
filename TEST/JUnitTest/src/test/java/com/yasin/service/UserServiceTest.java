package com.yasin.service;

import com.yasin.repository.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserService userService = new UserService();

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/MOCK_DATA.csv")
    void saveTestSuccess(ArgumentsAccessor arg) {
        User user = new User(
                null,
                arg.getString(1),
                arg.getString(2),
                arg.getString(3)
        );
        boolean isSave = userService.save(user);
        assertTrue(isSave);
    }
    @Test
    void saveErrorTest(){
        boolean isSave = userService.save(null);
        assertFalse(isSave);
    }
}