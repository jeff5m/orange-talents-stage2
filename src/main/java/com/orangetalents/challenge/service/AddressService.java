package com.orangetalents.challenge.service;

import com.orangetalents.challenge.mapper.AddressMapper;
import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressService {

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    public AddressService(AddressMapper addressMapper, AddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Long save(AddressPostRequestBody addressPostRequestBody) {
        Address addressToBeSaved = addressMapper.toAddress(addressPostRequestBody);
        return addressRepository.save(addressToBeSaved).getId();
    }
}
