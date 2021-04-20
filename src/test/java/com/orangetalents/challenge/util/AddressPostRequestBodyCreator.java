package com.orangetalents.challenge.util;

import com.orangetalents.challenge.model.requests.AddressPostRequestBody;

public class AddressPostRequestBodyCreator {
    public static AddressPostRequestBody createValidUserPostRequestBody() {
        return new AddressPostRequestBody(
                "Avenida Rondon Pacheco",
                "4600",
                "lado par",
                "Tibery",
                "Uberlândia",
                "MG",
                "38405142",
                1L
        );
    }
}
