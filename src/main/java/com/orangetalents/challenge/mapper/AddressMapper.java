package com.orangetalents.challenge.mapper;

import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface AddressMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user.id")
    Address toAddress(AddressPostRequestBody addressPostRequestBody);
}
