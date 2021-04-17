package com.orangetalents.challenge.mapper;

import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.requests.UserAddressesResponseBody;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ListOfUserAddressesResponseBodyMapper {

    List<UserAddressesResponseBody> toListOfUserAddressesResponseBody(List<Address> addresses);
}
