package com.orangetalents.challenge.mapper;

import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.requests.AddressPostResponseBody;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressPostResponseBodyMapper {

    AddressPostResponseBody toAddressPostResponseBody(Address address);
}
