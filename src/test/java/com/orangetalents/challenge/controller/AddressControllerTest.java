package com.orangetalents.challenge.controller;

import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.model.requests.AddressPostResponseBody;
import com.orangetalents.challenge.service.AddressService;
import com.orangetalents.challenge.util.AddressCreator;
import com.orangetalents.challenge.util.AddressPostRequestBodyCreator;
import com.orangetalents.challenge.util.AddressPostResponseBodyCreator;
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
class AddressControllerTest {

    @InjectMocks
    private AddressController addressController;
    @Mock
    private AddressService addressServiceMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(addressServiceMock.save(ArgumentMatchers.any()))
                .thenReturn(AddressPostResponseBodyCreator.createValidUserPostResponseBody());
    }

    @Test
    @DisplayName("save save Address and return AddressPostResponseBody when successful")
    void save_SavesAddressAndReturnAddressPostResponseBody_WhenSuccessful() {
        AddressPostRequestBody addressPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        AddressPostResponseBody addressPostResponseBody = this.addressController.save(addressPostRequestBody).getBody();

        Assertions.assertThat(addressPostResponseBody).isNotNull();
        Assertions.assertThat(addressPostResponseBody.getId()).isEqualTo(AddressCreator.createValidAddress().getId());
    }
}