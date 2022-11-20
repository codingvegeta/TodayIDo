//package controller;
//
//
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//import spring.RegisterRequest;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import spring.RegisterRequest;
//
//public class RegisterRequestValidator implements Validator {
//
//    private static final String emailRegExp =
//            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
//                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//    private Pattern pattern;
//
//    public RegisterRequestValidator() {
//        pattern = Pattern.compile(emailRegExp);
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return RegisterRequest.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        RegisterRequest regReq = (RegisterRequest) target;
//        if (regReq.getEmail() == null || regReq.getEmail().trim().isEmpty()) {
//            errors.rejectValue("email", "required");
//        } else {
//            Matcher matcher = pattern.matcher(regReq.getEmail());
//            if (!matcher.matches()) {
//                errors.rejectValue("email", "bad");
//            }
//        }
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
//        ValidationUtils.rejectIfEmpty(errors, "password", "required");
//        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
//        if (!regReq.getPassword().isEmpty()) {
//            if (!regReq.isPasswordEqualToConfirmPassword()) {
//                errors.rejectValue("confirmPassword", "nomatch");
//            }
//        }
//    }
//}
