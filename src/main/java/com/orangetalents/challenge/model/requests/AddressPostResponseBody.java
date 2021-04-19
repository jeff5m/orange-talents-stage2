package com.orangetalents.challenge.model.requests;

public class AddressPostResponseBody {
    private final Long id;

    public AddressPostResponseBody(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AddressPostResponseBody{" +
                "id=" + id +
                '}';
    }
}
