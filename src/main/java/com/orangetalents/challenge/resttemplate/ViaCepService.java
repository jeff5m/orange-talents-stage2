package com.orangetalents.challenge.resttemplate;

import com.orangetalents.challenge.model.requests.ViaCepAddress;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(url = "https://viacep.com.br/ws/", name = "viaCep")
public interface ViaCepService {
    @GetMapping(path = "{cep}/json")
    ViaCepAddress getAddressByCep(@PathVariable("cep") String cep);
}
