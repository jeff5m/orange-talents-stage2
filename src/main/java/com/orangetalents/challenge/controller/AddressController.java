package com.orangetalents.challenge.controller;

import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.model.requests.AddressPostResponseBody;
import com.orangetalents.challenge.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    @Operation(summary = "Persists a new Address", tags = "Address")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "When successful"),
            @ApiResponse(
                    responseCode = "400",
                    description = "When one or more fields are invalid",
                    content = @Content(schema = @Schema(hidden = true)))})
    public ResponseEntity<AddressPostResponseBody> save(@RequestBody
                                                        @Valid AddressPostRequestBody addressPostRequestBody) {
        return new ResponseEntity<>(addressService.save(addressPostRequestBody), HttpStatus.CREATED);
    }
}
