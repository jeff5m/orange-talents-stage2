package com.orangetalents.challenge.service;

import com.orangetalents.challenge.feignclient.ViaCepService;
import com.orangetalents.challenge.mapper.AddressMapper;
import com.orangetalents.challenge.mapper.AddressPostResponseBodyMapper;
import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.model.requests.AddressPostResponseBody;
import com.orangetalents.challenge.repository.AddressRepository;
import com.orangetalents.challenge.util.AddressCreator;
import com.orangetalents.challenge.util.AddressPostRequestBodyCreator;
import com.orangetalents.challenge.util.AddressPostResponseBodyCreator;
import com.orangetalents.challenge.util.ViaCepAddressCreator;
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
class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;
    @Mock
    private ViaCepService viaCepServiceMock;
    @Mock
    private AddressMapper addressMapperMock;
    @Mock
    private AddressPostResponseBodyMapper addressPostResponseBodyMapperMock;
    @Mock
    private AddressRepository addressRepositoryMock;

    @BeforeEach
    void setUp() {
        BDDMockito.when(viaCepServiceMock.getAddressByZipCode(ArgumentMatchers.any()))
                .thenReturn(ViaCepAddressCreator.createValidViaCepAddress());

        BDDMockito.when(addressMapperMock.toAddress(ArgumentMatchers.any()))
                .thenReturn(AddressCreator.createValidAddressToBeSaved());

        BDDMockito.when(addressRepositoryMock.save(ArgumentMatchers.any()))
                .thenReturn(AddressCreator.createValidAddress());

        BDDMockito.when(addressPostResponseBodyMapperMock.toAddressPostResponseBody(ArgumentMatchers.any()))
                .thenReturn(AddressPostResponseBodyCreator.createValidUserPostResponseBody());
    }

    @Test
    @DisplayName("save returns AddressPostResponseBody when successful")
    void save_ReturnsAddressPostResponseBody_WhenSuccessful() {
        AddressPostRequestBody addressPostRequestBody = AddressPostRequestBodyCreator.createValidUserPostRequestBody();
        AddressPostResponseBody savedAddress = this.addressService.save(addressPostRequestBody);

        Assertions.assertThat(savedAddress).isNotNull();
        Assertions.assertThat(savedAddress.getId()).isEqualTo(AddressCreator.createValidAddress().getId());
    }
}