package com.orangetalents.challenge.validations;

import com.orangetalents.challenge.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    private final UserService userService;

    public UniqueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value != null && value.contains("@")) {
            return userService.findByEmail(value).isEmpty();
        } else {
            String formattedCpf = Objects.requireNonNull(value).replaceAll("[\\D]", "");
            return userService.findByCpf(formattedCpf).isEmpty();
        }
    }
}
