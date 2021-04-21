package com.orangetalents.challenge.controller;

import com.orangetalents.challenge.model.requests.UserPostRequestBody;
import com.orangetalents.challenge.model.requests.UserPostResponseBody;
import com.orangetalents.challenge.model.requests.UserResponseBody;
import com.orangetalents.challenge.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Lists the data for a specific User and the Addresses associated with that User", tags = "User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "When successful"),
            @ApiResponse(
                    responseCode = "404",
                    description = "When no User is found",
                    content = @Content(schema = @Schema(hidden = true)))})
    public ResponseEntity<UserResponseBody> listUserAddresses(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findAllUserAddresses(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Persists a new User", tags = "User")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "When successful"),
            @ApiResponse(
                    responseCode = "400",
                    description = "When one or more fields are invalid",
                    content = @Content(schema = @Schema(hidden = true)))})
    public ResponseEntity<UserPostResponseBody> save(@RequestBody
                                                     @Valid UserPostRequestBody userPostRequestBody) {
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }
}
