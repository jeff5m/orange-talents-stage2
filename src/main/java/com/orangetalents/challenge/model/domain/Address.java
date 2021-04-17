package com.orangetalents.challenge.model.domain;

import javax.persistence.*;

@Entity
@SuppressWarnings({"squid:S1133", "squid:S1123", "squid:S1186"})
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String streetName;
    @Column(nullable = false)
    private String addressNumber;
    @Column(nullable = false)
    private String addOnAddress;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false, length = 8)
    private String cep;
    @ManyToOne(optional = false)
    private User user;

    @Deprecated
    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setAddOnAddress(String addOnAddress) {
        this.addOnAddress = addOnAddress;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!streetName.equals(address.streetName)) return false;
        if (!addressNumber.equals(address.addressNumber)) return false;
        if (!addOnAddress.equals(address.addOnAddress)) return false;
        if (!neighborhood.equals(address.neighborhood)) return false;
        if (!city.equals(address.city)) return false;
        if (!state.equals(address.state)) return false;
        if (!cep.equals(address.cep)) return false;
        return user.equals(address.user);
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
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
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
