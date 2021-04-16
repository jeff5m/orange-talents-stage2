package com.orangetalents.challenge.service;

import com.orangetalents.challenge.mapper.UserMapper;
import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserPostResponseBody save(@RequestBody @Valid UserPostRequestBody userPostRequestBody) {
        User userToBeSaved = userMapper.toUser(userPostRequestBody);
        User userSaved = userRepository.save(userToBeSaved);
        return userMapper.toUserPostResponseBody(userSaved);
    }
}
