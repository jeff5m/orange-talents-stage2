package com.orangetalents.challenge.model.requests;

@SuppressWarnings({"squid:S1133", "squid:S1123", "squid:S1186"})
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
