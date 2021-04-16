package com.orangetalents.challenge.validations;

import com.orangetalents.challenge.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueValidator implements ConstraintValidator<Unique, String> {

    private final UserService userService;

    public UniqueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value.contains("@")) {
            return userService.findByEmail(value).isEmpty();
        } else {
            return userService.findByCpf(value).isEmpty();
        }
    }
}
