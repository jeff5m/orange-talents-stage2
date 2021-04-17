package com.orangetalents.challenge.mapper;

import com.orangetalents.challenge.model.domain.Address;
import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserAddressesResponseBody;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "addresses", ignore = true)
    User toUser(UserPostRequestBody userPostRequestBody);

    UserPostResponseBody toUserPostResponseBody (User user);

    List<UserAddressesResponseBody> toListOfUserAddressesResponseBody(List<Address> addresses);
}
