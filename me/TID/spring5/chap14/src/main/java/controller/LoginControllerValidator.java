package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginControllerValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return LoginCommand.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
    }
}
