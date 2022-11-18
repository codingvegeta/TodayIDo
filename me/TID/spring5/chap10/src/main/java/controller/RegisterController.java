package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

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
            @RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
        if (!agree) {
            return "register/step1";
        }
        return "register/step2";
    }

    @GetMapping("/register/step2")
    public String handlerStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("/register/step3")
    public String handlerStep3(RegisterRequest request) {
        try {
            memberRegisterService.regist(request);
            return "register/step3";
        } catch (DuplicateMemberException ex) {
            return "register/step2";
        }
    }
}
