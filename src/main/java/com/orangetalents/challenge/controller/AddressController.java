package com.orangetalents.challenge.controller;

import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.model.requests.AddressPostResponseBody;
import com.orangetalents.challenge.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity<AddressPostResponseBody> save(@RequestBody
                                                        @Valid AddressPostRequestBody addressPostRequestBody) {
        return new ResponseEntity<>(addressService.save(addressPostRequestBody), HttpStatus.CREATED);
    }
}
