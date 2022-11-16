package spring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Member member = new Member(
                resultSet.getString("EMAIL"),
                resultSet.getString("PASSWORD"),
                resultSet.getString("NAME"),
                resultSet.getTimestamp("REGDATE").toLocalDateTime());
        member.setId(resultSet.getLong("ID"));
        return member;
    }
}
