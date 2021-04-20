package com.orangetalents.challenge.model.requests;

public class AddressPostResponseBody {
    private Long id;

    public AddressPostResponseBody(Long id) {
        this.id = id;
    }

    @Deprecated
    public AddressPostResponseBody() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AddressPostResponseBody{" +
                "id=" + id +
                '}';
    }
}
