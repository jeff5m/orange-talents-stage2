package com.orangetalents.challenge.util;

import com.orangetalents.challenge.model.requests.UserAddressesResponseBody;

public class UserAddressesResponseBodyCreator {

    public static UserAddressesResponseBody createValidUserAddressesResponseBody() {
        return new UserAddressesResponseBody(
                1L,
                "Avenida Rondon Pacheco",
                "4600",
                "lado par",
                "Tibery",
                "Uberlândia",
                "MG",
                "38405142"
        );
    }
}
