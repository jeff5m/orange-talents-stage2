package com.orangetalents.challenge.service;

import com.orangetalents.challenge.mapper.AddressMapper;
import com.orangetalents.challenge.mapper.AddressPostResponseBodyMapper;
import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.feignclient.ViaCepAddress;
import com.orangetalents.challenge.model.requests.AddressPostResponseBody;
import com.orangetalents.challenge.repository.AddressRepository;
import com.orangetalents.challenge.feignclient.ViaCepService;
import com.orangetalents.challenge.validations.ZipCodeInfoValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final ViaCepService viaCepService;
    private final AddressMapper addressMapper;
    private final AddressPostResponseBodyMapper addressPostResponseBodyMapper;

    public AddressService(AddressMapper addressMapper, AddressRepository addressRepository, ViaCepService viaCepService, AddressPostResponseBodyMapper addressPostResponseBodyMapper) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
        this.addressPostResponseBodyMapper = addressPostResponseBodyMapper;
    }

    @Transactional
    public AddressPostResponseBody save(AddressPostRequestBody addressPostRequestBody) {
        ViaCepAddress viaCepAddress = viaCepService.getAddressByZipCode(addressPostRequestBody.getZipCode());
        ZipCodeInfoValidator.validateAddress(viaCepAddress, addressPostRequestBody);
        Address addressToBeSaved = addressMapper.toAddress(addressPostRequestBody);
        Address addressSaved = addressRepository.save(addressToBeSaved);
        return addressPostResponseBodyMapper.toAddressPostResponseBody(addressSaved);
    }
}
