package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

import javax.validation.Valid;


@Controller
public class RegisterController {

    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/register/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String handler2(
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
        if (!agree) {
            return "register/step1";
        }
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register/step2";
    }

    @GetMapping("/register/step2")
    public String handlerStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("/register/step3")
    public String handlerStep3(@Valid RegisterRequest request, Errors errors) {
        if (errors.hasErrors()) {
            return "register/step2";
        }
        try {
            memberRegisterService.regist(request);
            return "register/step3";
        } catch (DuplicateMemberException ex) {
            errors.rejectValue("email","duplicate");
            return "register/step2";
        }
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new RegisterRequestValidator());
//    }
}
