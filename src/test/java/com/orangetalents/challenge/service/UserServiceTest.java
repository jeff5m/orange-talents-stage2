package com.orangetalents.challenge.service;

import com.orangetalents.challenge.exception.ResourceNotFoundException;
import com.orangetalents.challenge.mapper.UserMapper;
import com.orangetalents.challenge.mapper.UserPostResponseBodyMapper;
import com.orangetalents.challenge.mapper.UserResponseBodyMapper;
import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.model.requests.UserResponseBody;
import com.orangetalents.challenge.repository.UserRepository;
import com.orangetalents.challenge.util.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private UserMapper userMapperMock;
    @Mock
    private UserResponseBodyMapper userResponseBodyMapperMock;
    @Mock
    private UserPostResponseBodyMapper userPostResponseBodyMapperMock;


    @BeforeEach
    void setUp() {
        // listUserAddresses
        BDDMockito.when(userRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(UserCreator.createValidUser()));

        BDDMockito.when(userResponseBodyMapperMock.toUserResponseBody(ArgumentMatchers.any()))
                .thenReturn(UserResponseBodyCreator.createValidUserResponseBody());

        // save method
        BDDMockito.when(userMapperMock.toUser(ArgumentMatchers.any()))
                .thenReturn(UserCreator.createInvalidUserToBeSaved());

        BDDMockito.when(userRepositoryMock.save(ArgumentMatchers.any()))
                .thenReturn(UserCreator.createValidUser());

        BDDMockito.when(userPostResponseBodyMapperMock.toUserPostResponseBody(ArgumentMatchers.any()))
                .thenReturn(UserPostResponseBodyCreator.createValidUserPostResponseBody());

        // findByIdOrThrowResourceNotFoundException
        BDDMockito.when(userRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(UserCreator.createValidUser()));

        // findByEmail
        BDDMockito.when(userRepositoryMock.findByEmail(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(UserCreator.createValidUser()));

        // findByCpf
        BDDMockito.when(userRepositoryMock.findByCpf(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(UserCreator.createValidUser()));
    }

    @Test
    @DisplayName("listUserAddresses returns User data and list of Addresses when successful")
    void listUserAddresses_ReturnsUserDataAndListOfAddresses_WhenSuccessful() {
        User expectedUser = UserCreator.createValidUser();
        Address expectedAddress = AddressCreator.createValidAddress();
        UserResponseBody userResponse = userService.findAllUserAddresses(expectedUser.getId());

        Assertions.assertThat(userResponse).isNotNull();
        Assertions.assertThat(userResponse.getId()).isNotNull();
        Assertions.assertThat(userResponse.getName()).isEqualTo(expectedUser.getName());
        Assertions.assertThat(userResponse.getCpf()).isEqualTo(expectedUser.getCpf());
        Assertions.assertThat(userResponse.getEmail()).isEqualTo(expectedUser.getEmail());
        Assertions.assertThat(userResponse.getAddresses())
                .isNotNull()
                .hasSize(1);

        Assertions.assertThat(userResponse.getAddresses().get(0).getId())
                .isNotNull();
        Assertions.assertThat(userResponse.getAddresses().get(0).getStreetName())
                .isEqualTo(expectedAddress.getStreetName());
        Assertions.assertThat(userResponse.getAddresses().get(0).getAddressNumber())
                .isEqualTo(expectedAddress.getAddressNumber());
        Assertions.assertThat(userResponse.getAddresses().get(0).getAddOnAddress())
                .isEqualTo(expectedAddress.getAddOnAddress());
        Assertions.assertThat(userResponse.getAddresses().get(0).getNeighborhood())
                .isEqualTo(expectedAddress.getNeighborhood());
        Assertions.assertThat(userResponse.getAddresses().get(0).getCity())
                .isEqualTo(expectedAddress.getCity());
        Assertions.assertThat(userResponse.getAddresses().get(0).getState())
                .isEqualTo(expectedAddress.getState());
        Assertions.assertThat(userResponse.getAddresses().get(0).getZipCode())
                .isEqualTo(expectedAddress.getZipCode());
    }

    @Test
    @DisplayName("listUserAddresses returns User data and empty list of Addresses when no Address is found")
    void listUserAddresses_returnsUserDataAndEmptyListOfAddresses_WhenNoAddressIsFound() {
        BDDMockito.when(userService.findAllUserAddresses(ArgumentMatchers.anyLong()))
                .thenReturn(UserResponseBodyCreator.createValidUserResponseBodyWithEmptyList());

        User expectedUser = UserCreator.createValidUser();
        UserResponseBody userResponse = userService.findAllUserAddresses(expectedUser.getId());

        Assertions.assertThat(userResponse).isNotNull();
        Assertions.assertThat(userResponse.getId()).isNotNull();
        Assertions.assertThat(userResponse.getName()).isEqualTo(expectedUser.getName());
        Assertions.assertThat(userResponse.getCpf()).isEqualTo(expectedUser.getCpf());
        Assertions.assertThat(userResponse.getEmail()).isEqualTo(expectedUser.getEmail());
        Assertions.assertThat(userResponse.getAddresses())
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("save returns UserPostResponseBody when successful")
    void save_ReturnsUserPostResponseBody_WhenSuccessful() {
        UserPostRequestBody userPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        UserPostResponseBody userPostResponseBody = this.userService.save(userPostRequestBody);

        Assertions.assertThat(userPostResponseBody).isNotNull();
        Assertions.assertThat(userPostResponseBody.getId()).isEqualTo(UserCreator.createValidUser().getId());
    }

    @Test
    @DisplayName("findByIdOrThrowResourceNotFoundException finds User when successful")
    void findByIdOrThrowResourceNotFoundException_FindsUser_WhenSuccessful() {
        User expectedUser = UserCreator.createValidUser();
        User foundedUser = userService.findByIdOrThrowResourceNotFoundException(expectedUser.getId());

        Assertions.assertThat(foundedUser)
                .isNotNull()
                .isEqualTo(expectedUser);
    }

    @Test
    @DisplayName("findByIdOrThrowResourceNotFoundException throws ResourceNotFoundException when no user is found")
    void findByIdOrThrowResourceNotFoundException_ThrowsResourceNotFoundException_WhenNoUserIsFound() {
        BDDMockito.given(userRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .willThrow(new ResourceNotFoundException("User not found"));

        Assertions.assertThatExceptionOfType(ResourceNotFoundException.class)
                .isThrownBy(() -> this.userService.findByIdOrThrowResourceNotFoundException(1L))
                .withMessage("User not found");
    }

    @Test
    @DisplayName("findByEmail returns User when successful")
    void findByEmail_ReturnsUser_WhenSuccessful() {
        User expectedUser = UserCreator.createValidUser();
        Optional<User> optionalUser = userService.findByEmail(expectedUser.getEmail());

        Assertions.assertThat(optionalUser)
                .isNotNull()
                .isPresent()
                .isEqualTo(Optional.of(expectedUser));
    }

    @Test
    @DisplayName("findByEmail returns empty optional when no User is found")
    void findByEmail_ReturnsEmptyOptional_WhenNoUserIsFound() {
        BDDMockito.when(userRepositoryMock.findByEmail(ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());

        Optional<User> expectedUser = userService.findByEmail("test@email.com");

        Assertions.assertThat(expectedUser)
                .isNotNull()
                .isEmpty();
    }

    @Test
    @DisplayName("findByCpf returns User when successful")
    void findByCpf_ReturnsUser_WhenSuccessful() {
        User expectedUser = UserCreator.createValidUser();
        Optional<User> optionalUser = userService.findByEmail(expectedUser.getEmail());

        Assertions.assertThat(optionalUser)
                .isNotNull()
                .isPresent()
                .isEqualTo(Optional.of(expectedUser));
    }

    @Test
    @DisplayName("findByCpf returns empty optional when no User is found")
    void findByCpf_ReturnsEmptyOptional_WhenNoUserIsFound() {
        BDDMockito.when(userRepositoryMock.findByCpf(ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());

        Optional<User> expectedInstructor = userService.findByCpf("00000000000");

        Assertions.assertThat(expectedInstructor)
                .isNotNull()
                .isEmpty();
    }
}