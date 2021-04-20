package com.orangetalents.challenge.integration;

import com.orangetalents.challenge.exception.ValidationExceptionDetails;
import com.orangetalents.challenge.exception.ZipCodeValidationExceptionDetails;
import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.model.requests.AddressPostResponseBody;
import com.orangetalents.challenge.repository.UserRepository;
import com.orangetalents.challenge.util.AddressPostRequestBodyCreator;
import com.orangetalents.challenge.util.UserCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AddressControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        userRepository.save(UserCreator.createValidUserToBeSaved());
    }

    @Test
    @DisplayName("save save Address return status code 201 and AddressPostResponseBody when successful")
    void save_SavesAddressAndReturnAddressPostResponseBody_WhenSuccessful() {
        ResponseEntity<AddressPostResponseBody> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                AddressPostRequestBodyCreator.createValidUserPostRequestBody(),
                AddressPostResponseBody.class);
        AddressPostResponseBody addressPostResponseBody = addressPostResponseBodyResponseEntity.getBody();

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(AddressPostResponseBody.class);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        Assertions.assertThat(addressPostResponseBody).isNotNull();
        Assertions.assertThat(addressPostResponseBody.getId()).isNotNull();
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid street name")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidStreetName() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setStreetName("");

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid address number")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidAddressNumber() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setAddressNumber("");

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid neighborhood")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidNeighborhood() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setNeighborhood("");

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid city")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidCity() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setCity("");

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid state")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidState() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setState("");

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid state format")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidStateFormat() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setState("mgg");

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid zipCode")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidZipCode() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setZipCode("");

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ValidationExceptionDetails when AddressPostRequestBody has invalid user id")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasInvalidUserID() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setUserId(null);

        ResponseEntity<ValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ZipCodeValidationExceptionDetails when AddressPostRequestBody has conflict in the street name zip code info")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasConflictInTheStreetNameZipCodeInfo() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setZipCode("41385125");

        ResponseEntity<ZipCodeValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ZipCodeValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ZipCodeValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ZipCodeValidationExceptionDetails when AddressPostRequestBody has conflict in neighborhood zip code info")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasConflictInTheNeighborhoodZipCodeInfo() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setStreetName("Avenida Rondon Pacheco");
        userPostRequestBody.setZipCode("41385125");

        ResponseEntity<ZipCodeValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ZipCodeValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ZipCodeValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ZipCodeValidationExceptionDetails when AddressPostRequestBody has conflict in city zip code info")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasConflictInCityZipCodeInfo() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setStreetName("Avenida Rondon Pacheco");
        userPostRequestBody.setNeighborhood("Tibery");
        userPostRequestBody.setZipCode("41385125");

        ResponseEntity<ZipCodeValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ZipCodeValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ZipCodeValidationExceptionDetails.class);
    }

    @Test
    @DisplayName("save returns status code 400 and ZipCodeValidationExceptionDetails when AddressPostRequestBody has conflict in state zip code info")
    void save_ReturnsStatusCode400AndValidationExceptionDetails_WhenAddressPostRequestBodyHasConflictInStateZipCodeInfo() {
        AddressPostRequestBody userPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        userPostRequestBody.setStreetName("Avenida Rondon Pacheco");
        userPostRequestBody.setNeighborhood("Tibery");
        userPostRequestBody.setCity("Uberlândia");
        userPostRequestBody.setZipCode("41385125");

        ResponseEntity<ZipCodeValidationExceptionDetails> addressPostResponseBodyResponseEntity = testRestTemplate.postForEntity(
                "/address",
                userPostRequestBody,
                ZipCodeValidationExceptionDetails.class);

        Assertions.assertThat(addressPostResponseBodyResponseEntity).isNotNull();
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getStatusCode())
                .isNotNull()
                .isEqualTo(HttpStatus.BAD_REQUEST);
        Assertions.assertThat(addressPostResponseBodyResponseEntity.getBody())
                .isInstanceOf(ZipCodeValidationExceptionDetails.class);
    }
}
