package assembler;

import spring.ChangePasswordService;
import spring.Member;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {

    private MemberDao memberDao;
    private MemberRegisterService registerService;
    private ChangePasswordService passwordService;

    public Assembler() {
//        memberDao = new MemberDao();
        registerService = new MemberRegisterService();
        passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getRegisterService() {
        return registerService;
    }

    public ChangePasswordService getPasswordService() {
        return passwordService;
    }
}
