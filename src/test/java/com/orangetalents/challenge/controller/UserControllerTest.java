package com.orangetalents.challenge.controller;

import com.orangetalents.challenge.exception.ResourceNotFoundException;
import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.model.requests.UserResponseBody;
import com.orangetalents.challenge.service.UserService;
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

@ExtendWith(SpringExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userServiceMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(userServiceMock.findAllUserAddresses(ArgumentMatchers.anyLong()))
                .thenReturn(UserResponseBodyCreator.createValidUserResponseBody());
        BDDMockito.when(userServiceMock.save(ArgumentMatchers.any()))
                .thenReturn(UserPostResponseBodyCreator.createValidUserPostResponseBody());
    }

    @Test
    @DisplayName("listUserAddresses returns User data and all his addresses when successful")
    void listUserAddresses_returnsUserDataAndAllHisAddresses_WhenSuccessful() {
        User expectedUser = UserCreator.createValidUser();
        Address expectedAddress = AddressCreator.createValidAddress();
        UserResponseBody userResponse = userController.listUserAddresses(expectedUser.getId()).getBody();

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
    @DisplayName("listUserAddresses returns User data and empty list when no address is found")
    void listUserAddresses_returnsUserDataAndEmptyList_WhenNoAddressIsFound() {
        BDDMockito.when(userServiceMock.findAllUserAddresses(ArgumentMatchers.anyLong()))
                .thenReturn(UserResponseBodyCreator.createValidUserResponseBodyWithEmptyList());

        User expectedUser = UserCreator.createValidUser();
        UserResponseBody userResponse = userController.listUserAddresses(expectedUser.getId()).getBody();

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
    @DisplayName("save save user and return UserPostResponseBody when successful")
    void save_SavesUserAndReturnUserPostResponseBody_WhenSuccessful() {
        UserPostRequestBody userPostRequestBody = UserPostRequestBodyCreator.createValidUserPostRequestBody();
        UserPostResponseBody userPostResponseBody = this.userController.save(userPostRequestBody).getBody();

        Assertions.assertThat(userPostResponseBody).isNotNull();
        Assertions.assertThat(userPostResponseBody.getId()).isEqualTo(UserCreator.createValidUser().getId());
    }

    @Test
    @DisplayName("listUserAddresses throw ResourceNotFoundException when no user is found")
    void listUserAddresses_ThrowsResourceNotFoundException_WhenNoUserIsFound() {
        BDDMockito.given(userServiceMock.findAllUserAddresses(ArgumentMatchers.anyLong()))
                .willThrow(new ResourceNotFoundException("User not found"));

        Assertions.assertThatExceptionOfType(ResourceNotFoundException.class)
                .isThrownBy(() -> this.userController.listUserAddresses(1L))
                .withMessage("User not found");
    }
}