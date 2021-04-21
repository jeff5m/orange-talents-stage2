package com.orangetalents.challenge.service;

import com.orangetalents.challenge.exception.ResourceNotFoundException;
import com.orangetalents.challenge.mapper.UserMapper;
import com.orangetalents.challenge.mapper.UserPostResponseBodyMapper;
import com.orangetalents.challenge.mapper.UserResponseBodyMapper;
import com.orangetalents.challenge.model.domain.User;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.model.requests.UserResponseBody;
import com.orangetalents.challenge.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserPostResponseBodyMapper userPostResponseBodyMapper;
    private final UserResponseBodyMapper userResponseBodyMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserPostResponseBodyMapper userPostResponseBodyMapper, UserResponseBodyMapper userResponseBodyMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userPostResponseBodyMapper = userPostResponseBodyMapper;
        this.userResponseBodyMapper = userResponseBodyMapper;
        this.userRepository = userRepository;
    }

    public UserResponseBody findAllUserAddresses(Long userId) {
        User foundedUser = findByIdOrThrowResourceNotFoundException(userId);
        return userResponseBodyMapper.toUserResponseBody(foundedUser);
    }

    @Transactional
    public UserPostResponseBody save(UserPostRequestBody userPostRequestBody) {
        User userToBeSaved = userMapper.toUser(userPostRequestBody);
        User userSaved = userRepository.save(userToBeSaved);
        return userPostResponseBodyMapper.toUserPostResponseBody(userSaved);
    }

    public User findByIdOrThrowResourceNotFoundException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findByCpf(String cpf) {
        return userRepository.findByCpf(cpf);
    }
}
