package com.orangetalents.challenge.repository;

import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.util.AddressCreator;
import com.orangetalents.challenge.util.UserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;

@DataJpaTest
@DisplayName("Tests for AddressRepository")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        userRepository.save(UserCreator.createValidUserToBeSaved());
    }

    @Test
    @DisplayName("save persists address when successful")
    void save_PersistsAddress_WhenSuccessful() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        Address addressSaved = this.addressRepository.save(addressToBeSaved);

        Assertions.assertThat(addressSaved).isNotNull();
        Assertions.assertThat(addressSaved.getId()).isNotNull();
        Assertions.assertThat(addressSaved.getStreetName()).isEqualTo(addressToBeSaved.getStreetName());
        Assertions.assertThat(addressSaved.getAddressNumber()).isEqualTo(addressToBeSaved.getAddressNumber());
        Assertions.assertThat(addressSaved.getAddOnAddress()).isEqualTo(addressToBeSaved.getAddOnAddress());
        Assertions.assertThat(addressSaved.getNeighborhood()).isEqualTo(addressToBeSaved.getNeighborhood());
        Assertions.assertThat(addressSaved.getCity()).isEqualTo(addressToBeSaved.getCity());
        Assertions.assertThat(addressSaved.getState()).isEqualTo(addressToBeSaved.getState());
        Assertions.assertThat(addressSaved.getZipCode()).isEqualTo(addressToBeSaved.getZipCode());
        Assertions.assertThat(addressSaved.getUser().getId()).isEqualTo(UserCreator.createValidUser().getId());
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when streetName is null")
    void save_ThrowsDataIntegrityViolationException_WhenStreetNameIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setStreetName(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when addressNumber is null")
    void save_ThrowsDataIntegrityViolationException_WhenAddressNumberIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setAddressNumber(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when addOnAddress is null")
    void save_ThrowsDataIntegrityViolationException_WhenAddOnAddressIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setAddOnAddress(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when neighborhood is null")
    void save_ThrowsDataIntegrityViolationException_WhenNeighborhoodIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setStreetName(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when city is null")
    void save_ThrowsDataIntegrityViolationException_WhenCityIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setStreetName(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when state is null")
    void save_ThrowsDataIntegrityViolationException_WhenStateIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setStreetName(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when zip code is null")
    void save_ThrowsDataIntegrityViolationException_WhenZipCodeIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setStreetName(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }

    @Test
    @DisplayName("save throws DataIntegrityViolationException when UserId is null")
    void save_ThrowsDataIntegrityViolationException_WhenUserIdIsNull() {
        Address addressToBeSaved = AddressCreator.createValidAddressToBeSaved();
        addressToBeSaved.setStreetName(null);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(addressToBeSaved));
    }
}
