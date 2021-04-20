package com.orangetalents.challenge.util;

import com.orangetalents.challenge.model.requests.UserPostResponseBody;

public class UserPostResponseBodyCreator {
    public static UserPostResponseBody createValidUserPostResponseBody() {
        return new UserPostResponseBody(1L);
    }
}
