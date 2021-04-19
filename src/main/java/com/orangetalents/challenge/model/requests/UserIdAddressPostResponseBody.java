package com.orangetalents.challenge.model.requests;

@SuppressWarnings({"squid:S1133", "squid:S1123", "squid:S1186", "unused"})
public class UserIdAddressPostResponseBody {
    private Long id;

    @Deprecated
    public UserIdAddressPostResponseBody() {
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AddressUserPostResponseBody{" +
                "id=" + id +
                '}';
    }
}
