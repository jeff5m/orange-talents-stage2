package com.orangetalents.challenge.integration;

import com.orangetalents.challenge.exception.ResourceNotFoundException;
import com.orangetalents.challenge.exception.ValidationExceptionDetails;
import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.model.requests.UserResponseBody;
import com.orangetalents.challenge.repository.AddressRepository;
import com.orangetalents.challenge.repository.UserRepository;
import com.orangetalents.challenge.util.AddressCreator;
import com.orangetalents.challenge.util.UserCreator;
import com.orangetalents.challenge.util.UserPostRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.time.Month;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    @DisplayName("listUserAddresses returns status code 200, User data and list of Addresses when successful")
    void listUserAddresses_ReturnsStatusCode200UserDataAndListOfAddresses_WhenSuccessful() {
        User userSaved = this.userRepository.save(UserCreator.createValidUserToBeSaved());
        Long expectedId = userSaved.getId();
        Address addressSaved = this.addressRepository.save(AddressCreator.createValidAddressToBeSaved());
        String url = String.format("/users/%d/addresses", expectedId);

        ResponseEntity<UserResponseBody> userResponseBodyResponseEntity = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        UserResponseBody userResponseBody = userResponseBodyResponseEntity.getBody();

        Assertions.assertThat(userResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userResponseBodyResponseEntity.getBody())
                .isInstanceOf(UserResponseBody.class);
        Assertions.assertThat(userResponseBodyResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        Assertions.assertThat(userResponseBody).isNotNull();
        Assertions.assertThat(userResponseBody.getName()).isEqualTo(userSaved.getName());
        Assertions.assertThat(userResponseBody.getCpf()).isEqualTo(userSaved.getCpf());
        Assertions.assertThat(userResponseBody.getEmail()).isEqualTo(userSaved.getEmail());
        Assertions.assertThat(userResponseBody.getAddresses())
                .isNotNull()
                .hasSize(1);

        Assertions.assertThat(userResponseBody.getAddresses().get(0).getId())
                .isNotNull();
        Assertions.assertThat(userResponseBody.getAddresses().get(0).getStreetName())
                .isEqualTo(addressSaved.getStreetName());
        Assertions.assertThat(userResponseBody.getAddresses().get(0).getAddressNumber())
                .isEqualTo(addressSaved.getAddressNumber());
        Assertions.assertThat(userResponseBody.getAddresses().get(0).getAddOnAddress())
                .isEqualTo(addressSaved.getAddOnAddress());
        Assertions.assertThat(userResponseBody.getAddresses().get(0).getNeighborhood())
                .isEqualTo(addressSaved.getNeighborhood());
        Assertions.assertThat(userResponseBody.getAddresses().get(0).getCity())
                .isEqualTo(addressSaved.getCity());
        Assertions.assertThat(userResponseBody.getAddresses().get(0).getState())
                .isEqualTo(addressSaved.getState());
        Assertions.assertThat(userResponseBody.getAddresses().get(0).getZipCode())
                .isEqualTo(addressSaved.getZipCode());
    }

    @Test
    @DisplayName("listUserAddresses returns status code 200, User data and empty list of Addresses when no address is found")
    void listUserAddresses_ReturnsStatusCode200UserDataAndEmptyListOfAddresses_WhenNoAddressIsFound() {
        User userSaved = this.userRepository.save(UserCreator.createValidUserToBeSaved());
        Long expectedId = userSaved.getId();
        String url = String.format("/users/%d/addresses", expectedId);

        ResponseEntity<UserResponseBody> userResponseBodyResponseEntity = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });
        UserResponseBody userResponseBody = userResponseBodyResponseEntity.getBody();

        Assertions.assertThat(userResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userResponseBodyResponseEntity.getBody())
                .isInstanceOf(UserResponseBody.class);
        Assertions.assertThat(userResponseBodyResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        Assertions.assertThat(userResponseBody).isNotNull();
        Assertions.assertThat(userResponseBody.getName()).isEqualTo(userSaved.getName());
        Assertions.assertThat(userResponseBody.getCpf()).isEqualTo(userSaved.getCpf());
        Assertions.assertThat(userResponseBody.getEmail()).isEqualTo(userSaved.getEmail());
        Assertions.assertThat(userResponseBody.getAddresses())
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("save returns status code 201 and UserPostResponseBody when successful")
    void save_ReturnsStatusCode201AndUserPostResponseBody_WhenSuccessful() {
        ResponseEntity<UserPostResponseBody> userPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/users",
                UserPostRequestBodyCreator.createValidUserPostRequestBody(),
                UserPostResponseBody.class);
        UserPostResponseBody userPostResponseBody = userPostResponseBodyResponseEntity.getBody();

        Assertions.assertThat(userPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(UserPostResponseBody.class);
        Assertions.assertThat(userPostResponseBodyResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        Assertions.assertThat(userPostResponseBody).isNotNull();
        Assertions.assertThat(userPostResponseBody.getId()).isNotNull();

    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when UserPostRequestBody has invalid name")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenUserPostRequestBodyHasInvalidName() {
        UserPostRequestBody validUserPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        validUserPostRequestBody.setName("");

        ResponseEntity<ValidationExceptionDetails> userPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/users",
                validUserPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(userPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(userPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when UserPostRequestBody has invalid cpf")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenUserPostRequestBodyHasInvalidCpf() {
        UserPostRequestBody validUserPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        validUserPostRequestBody.setCpf("111111111");

        ResponseEntity<ValidationExceptionDetails> userPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/users",
                validUserPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(userPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(userPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when UserPostRequestBody has an already registered cpf")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenUserPostRequestBodyHasAnAlreadyRegisteredCpf() {
        String foundedCpf = this.userRepository.save(UserCreator.createValidUserToBeSaved()).getCpf();
        UserPostRequestBody validUserPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        validUserPostRequestBody.setCpf(foundedCpf);

        ResponseEntity<ValidationExceptionDetails> userPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/users",
                validUserPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(userPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(userPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when UserPostRequestBody has invalid email")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenUserPostRequestBodyHasInvalidEmail() {
        UserPostRequestBody validUserPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        validUserPostRequestBody.setEmail("asdf");

        ResponseEntity<ValidationExceptionDetails> userPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/users",
                validUserPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(userPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(userPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when UserPostRequestBody has an already registered email")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenUserPostRequestBodyHasAnAlreadyRegisteredEmail() {
        String foundedEmail = this.userRepository.save(UserCreator.createValidUserToBeSaved()).getEmail();
        UserPostRequestBody validUserPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        validUserPostRequestBody.setEmail(foundedEmail);

        ResponseEntity<ValidationExceptionDetails> userPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/users",
                validUserPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(userPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(userPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when UserPostRequestBody has invalid birthdate")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenUserPostRequestBodyHasInvalidBirthdate() {
        UserPostRequestBody validUserPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        validUserPostRequestBody.setBirthDate(LocalDate.of(2050, Month.JANUARY, 31));

        ResponseEntity<ValidationExceptionDetails> userPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/users",
                validUserPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(userPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(userPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("listUserAddresses returns status code 404 and ResourceNotFoundException when no user is found")
    void listUserAddresses_ReturnsStatusCode404AndResourceNotFoundException_WhenNoUserIsFound() {
        String url = String.format("/users/%d/addresses", 1L);
        ResponseEntity<ResourceNotFoundException> userResponseBodyResponseEntity = testRestTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                ResourceNotFoundException.class);

        Assertions.assertThat(userResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(userResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.NOT_FOUND);
        Assertions.assertThat(userResponseBodyResponseEntity.getBody()).isInstanceOf(ResourceNotFoundException.class);
    }
}
