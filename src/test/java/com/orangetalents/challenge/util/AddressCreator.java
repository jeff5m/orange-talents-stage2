package com.orangetalents.challenge.util;

import com.orangetalents.challenge.model.domain.Address;

public class AddressCreator {
    public static Address createValidAddress() {
        return new Address(
                1L,
                "Avenida Rondon Pacheco",
                "4600",
                "lado par",
                "Tibery",
                "Uberlândia",
                "MG",
                "38405142",
                UserCreator.createValidUser()
        );
    }

    public static Address createValidAddressToBeSaved() {
        return new Address(
                "Avenida Rondon Pacheco",
                "4600",
                "lado par",
                "Tibery",
                "Uberlândia",
                "MG",
                "38405142",
                UserCreator.createValidUser()
        );
    }

    public static Address createInvalidAddressToBeSaved() {
        return new Address(
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
