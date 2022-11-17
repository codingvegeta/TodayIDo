package spring;

import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {

    private MemberDao memberDao;

    @Transactional
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
