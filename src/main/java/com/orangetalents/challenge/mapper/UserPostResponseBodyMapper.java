package com.orangetalents.challenge.mapper;

import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserPostResponseBodyMapper {

    UserPostResponseBody toUserPostResponseBody (User user);
}
