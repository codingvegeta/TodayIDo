package hello.jdbc.repository;

import hello.jdbc.domain.Member;

import java.sql.SQLException;

//체크 예외를 던지려면 구현해야 하는 메서드들에서도 예외를 던져야 한다.
public interface MemberRepositoryEx {
    Member save(Member member) throws SQLException;

    Member findById(String memberId) throws SQLException;

    void update(String memberId, int money) throws SQLException;

    void delete(String memberId) throws SQLException;
}
