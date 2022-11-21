package controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.WrongIdPasswordException;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

    private ChangePasswordService changePasswordService;

    public void setChangePasswordService(ChangePasswordService changePasswordService) {
        this.changePasswordService = changePasswordService;
    }

    @GetMapping
    public String form(@ModelAttribute("command") ChangePwdCommand pwdCommand) {
        return "edit/changePwdForm";
    }

    @PostMapping
    public String submit(@ModelAttribute("command") ChangePwdCommand pwdCommand,
                         Errors errors, HttpSession session) {
        new ChangePwdCommandValidator().validate(pwdCommand, errors);
        if (errors.hasErrors()) {
            return "edit/changePwdForm";
        }
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        try {
            changePasswordService.changePassword(
                    authInfo.getEmail(),
                    pwdCommand.getCurrentPassword(),
                    pwdCommand.getNewPassword());
            return "edit/changePwd";
        } catch (WrongIdPasswordException e) {
            errors.reject("currentPassword", "notMatching");
            return "edit/changePwdForm";
        }
    }
}
