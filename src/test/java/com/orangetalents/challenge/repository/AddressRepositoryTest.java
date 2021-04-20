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
    @DisplayName("Save persists address when successful")
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
    @DisplayName("Save throw DataIntegrityViolationException when attributes are null")
    void save_ThrowsDataIntegrityViolationException_WhenSuccessful() {
        Address invalidAddressToBeSaved = AddressCreator.createInvalidAddressToBeSaved();

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.addressRepository.save(invalidAddressToBeSaved));
    }
}