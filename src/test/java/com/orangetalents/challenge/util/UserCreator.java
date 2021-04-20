package com.orangetalents.challenge.util;

import com.orangetalents.challenge.model.domain.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

public class UserCreator {
    public static User createValidUser() {
        return new User(
                1L,
                "Jane Doe",
                "test@email.com",
                "09398470004",
                LocalDate.of(1999, Month.JUNE, 6),
                Collections.emptyList());
    }

    public static User createValidUserToBeSaved() {
        return new User(
                "Jane Doe",
                "test@email.com",
                "09398470004",
                LocalDate.of(1999, Month.JUNE, 6));
    }

    public static User createInvalidUserToBeSaved() {
        return new User(
                null,
                null,
                null,
                null);
    }
}
