package com.orangetalents.challenge.model.requests;

import com.orangetalents.challenge.model.domain.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressPostRequestBody {
    @NotBlank(message = "Address must have a street name")
    private final String streetName;
    @NotBlank(message = "Address must have a number")
    private final String addressNumber;
    private final String addOnAddress;
    @NotBlank(message = "Address must have a neighborhood")
    private final String neighborhood;
    @NotBlank(message = "Address must have a city")
    private final String city;
    @NotBlank(message = "Address must have a state")
    private final String state;
    @NotBlank(message = "Address must have a cep")
    private final String cep;
    @NotNull(message = "Address must have an User")
    private final User user;

    public AddressPostRequestBody(@NotBlank String streetName,
                                  String addressNumber,
                                  String addOnAddress,
                                  @NotBlank String neighborhood,
                                  @NotBlank String city,
                                  @NotBlank String state,
                                  @NotBlank String cep,
                                  @NotNull User user) {
        this.streetName = streetName;
        this.addressNumber = addressNumber;
        this.addOnAddress = addOnAddress;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.user = user;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getAddOnAddress() {
        return addOnAddress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressPostRequestBody that = (AddressPostRequestBody) o;

        if (!streetName.equals(that.streetName)) return false;
        if (!addressNumber.equals(that.addressNumber)) return false;
        if (!addOnAddress.equals(that.addOnAddress)) return false;
        if (!neighborhood.equals(that.neighborhood)) return false;
        if (!city.equals(that.city)) return false;
        if (!state.equals(that.state)) return false;
        if (!cep.equals(that.cep)) return false;
        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        int result = streetName.hashCode();
        result = 31 * result + addressNumber.hashCode();
        result = 31 * result + addOnAddress.hashCode();
        result = 31 * result + neighborhood.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + cep.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AddressPostRequestBody{" +
                "streetName='" + streetName + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                ", addOnAddress='" + addOnAddress + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cep='" + cep + '\'' +
                ", user=" + user +
                '}';
    }
}
