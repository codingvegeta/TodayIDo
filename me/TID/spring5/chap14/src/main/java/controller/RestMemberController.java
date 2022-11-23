package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class RestMemberController {
    private MemberDao memberDao;
    private MemberRegisterService registerService;

    @GetMapping("/api/members")
    public List<Member> members() {
        return memberDao.selectAll();
    }

//    @GetMapping("/api/members/{id}")
//    public ResponseEntity<Object> member(@PathVariable Long id,
//                                         HttpServletResponse response) throws IOException {
//        Member member = memberDao.selectById(id);
//        if (member == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(new ErrorResponse("no member"));
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(member);
//    }

    @GetMapping("/api/members/{id}")
    public Member member(@PathVariable Long id) {
        Member member = memberDao.selectById(id);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        return member;
    }

    @PostMapping("/api/members")
    public void newMember(@RequestBody @Valid RegisterRequest request,
                          HttpServletResponse response) throws IOException {
        try {
            Long newMemberId = registerService.regist(request);
            response.setHeader("Location", "/api/members/" + newMemberId);
            response.setStatus(HttpServletResponse.SC_CREATED);
        } catch (DuplicateMemberException dupEx) {
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

    public void setMemberDao(MemberDao memberDao) {

        this.memberDao = memberDao;
    }

    public void setRegisterService(MemberRegisterService registerService) {
        this.registerService = registerService;
    }
}
