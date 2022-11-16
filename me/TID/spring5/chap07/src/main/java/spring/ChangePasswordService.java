package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {

    @Autowired
    private MemberDao memberDao;

    public void changePassword(String email, String oldPassword, String newPassword) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPassword, newPassword);

        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
}
