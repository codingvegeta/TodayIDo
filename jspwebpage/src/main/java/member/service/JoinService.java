package member.service;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class JoinService {

    private MemberDao memberDao = new MemberDao();

    public void join(JoinRequest joinReq) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false); // DB커넥션을 구하고, 트랜잭션을 시작한다.

            Member member = memberDao.selectById(conn, joinReq.getId()); // memberdao의 select를 이용해서 joinreq.getid에
            //해당하는 회원 데이터를 구한다.
            if (member != null) {
                JdbcUtil.rollback(conn);
                throw new DuplicateIdException(); // 해당 아이디가 이미 존재하면 DuplicateRequestException 을 발생시킨다.
            }

            memberDao.insert(conn, //회원 데이터가 중복이 아닐경우 member객체를 생성한 후 insert를 이용해서 회원 데이터를 테이블에 삽입한다.
                    new Member(
                            joinReq.getId(),
                            joinReq.getName(),
                            joinReq.getPassword(),
                            new Date())
            );
            conn.commit();
        } catch (SQLException e) {
            JdbcUtil.rollback(conn);
            throw new RuntimeException(e); // 처리중 SQL exception이 발생할경우 롤백 후 jb를 종료한다.
        }finally {
            JdbcUtil.close(conn);
        }
    }
}
