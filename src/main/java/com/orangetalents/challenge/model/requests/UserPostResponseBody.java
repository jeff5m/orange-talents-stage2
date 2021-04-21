package com.orangetalents.challenge.model.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@SuppressWarnings({"squid:S1133", "squid:S1123", "squid:S1186"})
public class UserPostResponseBody {

    @Schema(description = "This is the User id",
            example = "1")
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
