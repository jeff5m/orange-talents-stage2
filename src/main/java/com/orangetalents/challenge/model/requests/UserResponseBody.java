package com.orangetalents.challenge.model.requests;

import java.util.List;

public class UserResponseBody {

    private final Long id;
    private final String name;
    private final String email;
    private final String cpf;
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
