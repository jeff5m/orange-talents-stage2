package com.orangetalents.challenge.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(url = "https://viacep.com.br/ws/", name = "viaCep")
public interface ViaCepService {

    @GetMapping(path = "{zipCode}/json")
    ViaCepAddress getAddressByZipCode(@PathVariable("zipCode") String zipCode);
}
