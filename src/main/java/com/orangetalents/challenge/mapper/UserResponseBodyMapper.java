package com.orangetalents.challenge.mapper;

import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserResponseBody;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseBodyMapper {

    UserResponseBody toUserResponseBody(User user);
}
