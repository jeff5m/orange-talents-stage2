package com.orangetalents.challenge.model.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressPostRequestBody {
    @NotBlank(message = "Address must have a street name")
    private final String streetName;
    @NotBlank(message = "Address must have a number")
    private final String addressNumber;
    @NotBlank(message = "Address must have an add-on")
    private final String addOnAddress;
    @NotBlank(message = "Address must have a neighborhood")
    private final String neighborhood;
    @NotBlank(message = "Address must have a city")
    private final String city;
    @NotBlank(message = "Address must have a state")
    private final String state;
    @NotBlank(message = "Address must have a ZIP Code")
    @Pattern(message = "ZIP Code must contain 8 numbers", regexp = "[0-9]{8}")
    private final String zipCode;
    @NotNull(message = "The address must have an user-id")
    private final Long userId;

    public AddressPostRequestBody(@NotBlank String streetName,
                                  @NotBlank String addressNumber,
                                  @NotBlank String addOnAddress,
                                  @NotBlank String neighborhood,
                                  @NotBlank String city,
                                  @NotBlank String state,
                                  @NotBlank String zipCode,
                                  @NotNull Long userId) {
        this.streetName = streetName;
        this.addressNumber = addressNumber;
        this.addOnAddress = addOnAddress;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
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
        if (!zipCode.equals(that.zipCode)) return false;
        return userId.equals(that.userId);
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
        result = 31 * result + userId.hashCode();
        return result;
    }
}
