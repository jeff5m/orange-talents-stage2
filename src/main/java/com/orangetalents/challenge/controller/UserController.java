package com.orangetalents.challenge.controller;

import com.orangetalents.challenge.model.requests.UserAddressesResponseBody;
import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.service.UserService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}/address")
    public ResponseEntity<List<UserAddressesResponseBody>> listUserAddresses(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(userService.findAllUserAddresses(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserPostResponseBody> save(@RequestBody
                                     @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }
}
