package com.orangetalents.challenge.service;

import com.orangetalents.challenge.mapper.AddressMapper;
import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.model.requests.ViaCepAddress;
import com.orangetalents.challenge.repository.AddressRepository;
import com.orangetalents.challenge.resttemplate.ViaCepService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AddressService {

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    private final ViaCepService viaCepService;

    public AddressService(AddressMapper addressMapper, AddressRepository addressRepository, ViaCepService viaCepService) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
        this.viaCepService = viaCepService;
    }

    @Transactional
    public Long save(AddressPostRequestBody addressPostRequestBody) {
        ViaCepAddress viaCepAddress = viaCepService.getAddressByCep(addressPostRequestBody.getCep());
        Long userId = addressPostRequestBody.getUser().getId();
        Address addressToBeSaved = addressMapper.toAddress(viaCepAddress, userId, addressPostRequestBody.getAddressNumber());
        return addressRepository.save(addressToBeSaved).getId();
    }
}
