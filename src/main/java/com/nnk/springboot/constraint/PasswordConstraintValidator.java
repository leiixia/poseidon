package com.nnk.springboot.constraint;

import org.passay.*;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1)
                );

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();

        context.buildConstraintViolationWithTemplate(
                        String.join(",",validator.getMessages(result)))
                .addConstraintViolation();
        return false;
    }
}
