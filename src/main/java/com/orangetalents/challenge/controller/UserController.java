package com.orangetalents.challenge.controller;

import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.model.requests.UserResponseBody;
import com.orangetalents.challenge.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}/addresses")
    public ResponseEntity<UserResponseBody> listUserAddresses(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findAllUserAddresses(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserPostResponseBody> save(@RequestBody
                                                     @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }
}
