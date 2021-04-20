package com.orangetalents.challenge.model.requests;

public class UserPostResponseBody {
    private Long id;

    public UserPostResponseBody(Long id) {
        this.id = id;
    }

    @Deprecated
    public UserPostResponseBody() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserPostResponseBody{" +
                "id=" + id +
                '}';
    }
}
