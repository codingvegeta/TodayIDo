package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    public final JdbcTemplate template;

    public MemberRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void initTable() {
        template.execute("create table member(member_id varchar primary key, name varchar)");
    }

    public void save(Member member) {
        template.update("insert into member(member_id, name) values (?,?)",
                member.getMemberId(),
                member.getName());
    }

    public Member find(String memberId) {
        return template.queryForObject("select member_id, name from member where member_id =?",
                BeanPropertyRowMapper.newInstance(Member.class));
    }

    public List<Member> findAll() {
        return template.query("select member_id, name from memer",
                BeanPropertyRowMapper.newInstance(Member.class));
    }
}
