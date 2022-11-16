package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER where EMAIL = ?",
                new MemberRowMapper(), email);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {

    }

    public void update(Member member) {

    }

    public List<Member> selectAll() {
        List<Member> result = jdbcTemplate.query("select * from MEMBER", new MemberRowMapper());
        return result;
    }

}
