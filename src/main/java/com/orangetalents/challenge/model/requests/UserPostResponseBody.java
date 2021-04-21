package com.orangetalents.challenge.model.requests;

@SuppressWarnings({"squid:S1133", "squid:S1123", "squid:S1186"})
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
