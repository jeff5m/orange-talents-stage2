package com.orangetalents.challenge.model.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class UserResponseBody {

    @Schema(description = "This is the User id", example = "1")
    private final Long id;

    @Schema(description = "This is the User name", example = "Jane Doe")
    private final String name;

    @Schema(description = "This is the User email", example = "jane@email.com")
    private final String email;

    @Schema(description = "This is the User cpf", example = "12345678910")
    private final String cpf;

    @Schema(description = "This is the list of Addresses associated with this User")
    private final List<UserAddressesResponseBody> addresses;

    public UserResponseBody(Long id, String name, String email, String cpf, List<UserAddressesResponseBody> addresses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.addresses = addresses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public List<UserAddressesResponseBody> getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserResponseBody that = (UserResponseBody) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!email.equals(that.email)) return false;
        if (!cpf.equals(that.cpf)) return false;
        return addresses.equals(that.addresses);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + addresses.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserResponseBody{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
