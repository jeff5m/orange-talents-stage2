package com.orangetalents.challenge.model.requests;

public class UserPostResponseBody {
    private final Long id;

    public UserPostResponseBody(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserPostResponseBody{" +
                "id=" + id +
                '}';
    }
}
