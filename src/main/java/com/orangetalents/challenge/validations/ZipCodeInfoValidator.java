package com.orangetalents.challenge.validations;

import com.orangetalents.challenge.exception.ZipCodeValidationException;
import com.orangetalents.challenge.exception.ResourceNotFoundException;
import com.orangetalents.challenge.model.requests.AddressPostRequestBody;
import com.orangetalents.challenge.feignclient.ViaCepAddress;

import java.util.Locale;

public class ZipCodeInfoValidator {

    private ZipCodeInfoValidator() {
    }

    public static void validateAddress(ViaCepAddress viaCepAddress, AddressPostRequestBody addressPostRequestBody) {

        boolean validStreetName = !viaCepAddress.getLogradouro().equals("") && !viaCepAddress.getLogradouro().equals(addressPostRequestBody.getStreetName());
        boolean validNeighborhood = !viaCepAddress.getBairro().equals("") && !viaCepAddress.getBairro().toLowerCase(Locale.ROOT).equals(addressPostRequestBody.getNeighborhood().toLowerCase(Locale.ROOT));
        boolean validCity = !viaCepAddress.getLocalidade().toLowerCase(Locale.ROOT).equals(addressPostRequestBody.getCity().toLowerCase(Locale.ROOT));
        boolean validState = !viaCepAddress.getUf().toLowerCase(Locale.ROOT).equals(addressPostRequestBody.getState().toLowerCase(Locale.ROOT));

        if (viaCepAddress.getUf() == null) {
            throw new ResourceNotFoundException("The informed zipCode does not exist");
        } else if (validStreetName) {
            throw new ZipCodeValidationException("The street name entered does not match the street name associated with this zip code");
        } else if (validNeighborhood) {
            throw new ZipCodeValidationException("The neighborhood entered does not match the neighborhood associated with this zip code");
        } else if (validCity) {
            throw new ZipCodeValidationException("The city entered does not match the city associated with this zip code");
        } else if (validState) {
            throw new ZipCodeValidationException("The state entered does not match the state associated with this zip code");
        }
    }
}
