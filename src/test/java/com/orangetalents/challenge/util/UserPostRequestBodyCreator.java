package com.orangetalents.challenge.util;

import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;

import java.time.LocalDate;
import java.time.Month;

public class UserPostRequestBodyCreator {
    public static UserPostRequestBody createValidUserPostRequestBody() {
        return new UserPostRequestBody(
                "Jane Doe",
                "test@email.com",
                "09398470004",
                LocalDate.of(1999, Month.JUNE, 6));
    }
}
