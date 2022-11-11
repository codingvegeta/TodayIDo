package guestbook.service;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

import java.sql.Connection;
import java.sql.SQLException;

public class DeleteMessageService {

    private static DeleteMessageService instance = new DeleteMessageService();

    public static DeleteMessageService getInstance() {
        return instance;
    }

    private DeleteMessageService(){}

    public void deleteMessage(int messageId, String password) {
        Connection conn = null;
        try {
            conn = ConnectionProvider.getConnection();
            conn.setAutoCommit(false);

            MessageDao messageDao = MessageDao.getInstance();
            Message message = messageDao.select(conn, messageId);
            if (message == null) {
                throw new MessageNotFoundExeption("메시지 없음");
            }
            if (!message.matchPassword(password)) {
                throw new InvalidPasswordException("bad password");
            }
            messageDao.delete(conn, messageId);

            conn.commit();
        } catch (SQLException ex) {
            JdbcUtil.rollback(conn);
            throw new ServiceException("삭제 실패: " + ex.getMessage(), ex);
        } catch (InvalidPasswordException | MessageNotFoundExeption ex) {
            JdbcUtil.rollback(conn);
            throw ex;
        }finally {
            JdbcUtil.close(conn);
        }
    }
}
