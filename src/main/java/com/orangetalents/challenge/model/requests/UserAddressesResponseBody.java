package com.orangetalents.challenge.model.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@SuppressWarnings("unused")
public class UserAddressesResponseBody {

    @Schema(description = "This is the Address id", example = "1")
    private final Long id;

    @Schema(description = "This is the Address street name", example = "Avenida Rondon Pacheco")
    private final String streetName;

    @Schema(description = "This is the Address number", example = "4600")
    private final String addressNumber;

    @Schema(description = "This is the Address add-on", example = "7° e 8° Andar")
    private final String addOnAddress;

    @Schema(description = "This is the Address neighborhood", example = "Tibery")
    private final String neighborhood;

    @Schema(description = "This is the Address city", example = "Uberlândia")
    private final String city;

    @Schema(description = "This is the Address state", example = "MG")
    private final String state;

    @Schema(description = "This is the Address ZIP code", example = "38405142")
    private final String zipCode;


    public UserAddressesResponseBody(Long id, String streetName, String addressNumber, String addOnAddress, String neighborhood, String city, String state, String zipCode) {
        this.id = id;
        this.streetName = streetName;
        this.addressNumber = addressNumber;
        this.addOnAddress = addOnAddress;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
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

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAddressesResponseBody that = (UserAddressesResponseBody) o;

        if (!streetName.equals(that.streetName)) return false;
        if (!addressNumber.equals(that.addressNumber)) return false;
        if (!addOnAddress.equals(that.addOnAddress)) return false;
        if (!neighborhood.equals(that.neighborhood)) return false;
        if (!city.equals(that.city)) return false;
        if (!state.equals(that.state)) return false;
        return zipCode.equals(that.zipCode);
    }

    @Override
    public int hashCode() {
        int result = streetName.hashCode();
        result = 31 * result + addressNumber.hashCode();
        result = 31 * result + addOnAddress.hashCode();
        result = 31 * result + neighborhood.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + zipCode.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserAddressesResponseBody{" +
                "streetName='" + streetName + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                ", addOnAddress='" + addOnAddress + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", cep='" + zipCode + '\'' +
                '}';
    }
}
