package spring;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;
    private RowMapper<Member> memberRowMapper = new RowMapper<Member>() {
        @Override
        public Member mapRow(ResultSet resultSet, int i) throws SQLException {
            Member member = new Member(
                    resultSet.getString("EMAIL"),
                    resultSet.getString("PASSWORD"),
                    resultSet.getString("NAME"),
                    resultSet.getTimestamp("REGDATE").toLocalDateTime());
            member.setId(resultSet.getLong("ID"));
            return member;
        }
    };

    public MemberDao(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?",memberRowMapper, email);

        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(final Member member) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT into MEMBER (EMAIL, PASSWORD, NAME, REGDATE)" +
                                "values (?, ?, ?, ?)", new String[]{"ID"});
                pstmt.setString(1, member.getEmail());
                pstmt.setString(2, member.getPassword());
                pstmt.setString(3, member.getName());
                pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
                return pstmt;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update(
                "update MEMBER set NAME =?, PASSWORD =? WHERE EMAIL =  ?",
                member.getName(), member.getPassword(), member.getEmail());
    }

    public List<Member> selectAll() {
        List<Member> result = jdbcTemplate.query("select * from MEMBER", memberRowMapper );
        return result;
    }

    public int count() {
        Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
        return count;
    }

    public List<Member> selectByRegdate(
            LocalDateTime from,LocalDateTime to) {
        List<Member> result = jdbcTemplate.query(
                "select * from MEMBER where REGDATE between ? and ? order by REGDATE desc",
                memberRowMapper, from, to);
        return result;
    }

    public Member selectById(Long memId) {
        List<Member> result = jdbcTemplate.query("select * from MEMBER where ID = ?", memberRowMapper, memId);
        return result.isEmpty() ? null : result.get(0);
    }


}
