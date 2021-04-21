package com.orangetalents.challenge.util;

import com.orangetalents.challenge.model.requests.UserResponseBody;

import java.util.Collections;
import java.util.List;

public class UserResponseBodyCreator {

    public static UserResponseBody createValidUserResponseBody() {
        return new UserResponseBody(
                1L,
                "Jane Doe",
                "test@email.com",
                "09398470004",
                List.of(UserAddressesResponseBodyCreator.createValidUserAddressesResponseBody()));
    }

    public static UserResponseBody createValidUserResponseBodyWithEmptyList() {
        return new UserResponseBody(
                1L,
                "Jane Doe",
                "test@email.com",
                "09398470004",
                Collections.emptyList());
    }
}
