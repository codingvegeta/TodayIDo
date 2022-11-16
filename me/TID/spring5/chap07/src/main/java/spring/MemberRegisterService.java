package spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class MemberRegisterService {
    @Autowired
    private MemberDao memberDao;

    public MemberRegisterService() {

    }

    public Long regist(RegisterRequest request) {
        Member member = memberDao.selectByEmail(request.getEmail());
        if (member != null) {
            throw new DuplicateMemberException("dup email" + request.getEmail());
        }
        Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();

    }
}
