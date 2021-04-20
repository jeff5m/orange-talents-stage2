package com.orangetalents.challenge.util;

import com.orangetalents.challenge.feignclient.ViaCepAddress;

public class ViaCepAddressCreator {
    public static ViaCepAddress createValidViaCepAddress() {
        return new ViaCepAddress(
                "Avenida Rondon Pacheco",
                "Tibery",
                "Uberlândia",
                "MG"
        );
    }
}
