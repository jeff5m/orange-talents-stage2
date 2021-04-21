package com.orangetalents.challenge.model.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@SuppressWarnings({"squid:S1133", "squid:S1123", "squid:S1186"})
public class AddressPostRequestBody {

    @NotBlank(message = "Address must have a street name")
    @Schema(description = "This is the Address street name",
            example = "Avenida Rondon Pacheco",
            required = true)
    private String streetName;

    @NotBlank(message = "Address must have a number")
    @Schema(description = "This is the Address number",
            example = "4600",
            required = true)
    private String addressNumber;

    @NotBlank(message = "Address must have an add-on")
    @Schema(description = "This is the Address add-on",
            example = "7° e 8° Andar",
            required = true)
    private String addOnAddress;

    @NotBlank(message = "Address must have a neighborhood")
    @Schema(description = "This is the Address neighborhood",
            example = "Tibery",
            required = true)
    private String neighborhood;

    @NotBlank(message = "Address must have a city")
    @Schema(description = "This is the Address city",
            example = "Uberlândia",
            required = true)
    private String city;

    @NotBlank(message = "Address must have a state")
    @Pattern(message = "Must consist of two capital letters", regexp = "[A-Z]{2}")
    @Schema(description = "This is the Address state",
            example = "MG",
            required = true)
    private String state;

    @NotBlank(message = "Address must have a ZIP Code")
    @Pattern(message = "ZIP Code must contain 8 numbers", regexp = "[0-9]{8}")
    @Schema(description = "This is the Address ZIP code",
            example = "38405142",
            required = true)
    private String zipCode;

    @NotNull(message = "The address must have an User id")
    @Schema(description = "This number represents the User id associated with this Address",
            example = "1",
            required = true)
    private Long userId;


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

    @Deprecated
    public AddressPostRequestBody() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddOnAddress() {
        return addOnAddress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
