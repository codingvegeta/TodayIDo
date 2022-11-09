package member.dao;

import jdbc.JdbcUtil;
import member.model.Member;

import java.sql.*;
import java.util.Date;

public class MemberDao {

    public Member selectById(Connection conn,String id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(
                    "select * from member where memberid = ?");
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();
            Member member = null;
            if (rs.next()) {
                member = new Member(
                        rs.getString("memberid"),
                        rs.getString("name"),
                        rs.getString("password"),
                        toDate(rs.getTimestamp("regdate")));

            }
            return member;
        }finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }

    private Date toDate(Timestamp date) {
        return date == null ? null : new Date(date.getTime());
    }

    public void insert(Connection conn, Member member) throws SQLException {
        try (PreparedStatement pstmt =
                     conn.prepareStatement("insert into member values(?,?,?,?)")) {
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getPassword());
            pstmt.setTimestamp(4, new Timestamp(member.getRegDate().getTime()));
            pstmt.executeUpdate();

        }

        }
    }

