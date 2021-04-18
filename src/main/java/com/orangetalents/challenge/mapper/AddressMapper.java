package com.orangetalents.challenge.mapper;

import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.requests.ViaCepAddress;
import com.orangetalents.challenge.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "userId")
    @Mapping(target = "streetName", source = "viaCepAddress.logradouro")
    @Mapping(target = "addOnAddress", source = "viaCepAddress.complemento")
    @Mapping(target = "neighborhood", source = "viaCepAddress.bairro")
    @Mapping(target = "city", source = "viaCepAddress.localidade")
    @Mapping(target = "state", source = "viaCepAddress.uf")
    Address toAddress(ViaCepAddress viaCepAddress, Long userId, String addressNumber);
}
