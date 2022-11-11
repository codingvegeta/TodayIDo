package jdbc;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.DriverManager;

public class DBCPinit extends HttpServlet {

    @Override
    public void init() throws ServletException {
        loadJDBCDriver();
        intiConnetionPool();
    }


    private void loadJDBCDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex){
            throw new RuntimeException("fail to load JDBC Driver", ex);
        }
    }

    private void intiConnetionPool() {
        try {
            String jdbcUrl =
                    "jdbc:mysql://localhost:3306/guestbook?" +
                            "useUnicode=true&characterEncoding=utf8";
            String username = "jspexam";
            String pw = "jsppw";

            ConnectionFactory connFactory =
                    new DriverManagerConnectionFactory(jdbcUrl, username, pw);

            PoolableConnectionFactory poolableConnFactory =
                    new PoolableConnectionFactory(connFactory, null);
            poolableConnFactory.setValidationQuery("select1"); // 커넥션이 유효한지 여부를 검색할때 사용할 쿼리를 지정한다.
            //DBCP는 커넥션 풀에 커넥션을 보관할 때 PoolableConnection 을 사용한다.
            //이 클래스는 실제 커넥션을 담고있으며, 실제 커넥션 풀을 관리하는데 필요한 기능을 제공한다.
            //close()를 사용하면 커넥션을 종료하지않고 풀에 커넥션을 반환한다.

            //커넥션풀의 설정 정보를 생성한다.
            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L); // 유휴 커넥션 검사 주기
            poolConfig.setTestWhileIdle(true); //풀에 보관중인 커넥션이 유효한지 검사할지 여부
            poolConfig.setMaxIdle(4); // 커넥션 최소 개수
            poolConfig.setMaxTotal(50); // 커넥션 최대 개수


            //커넥션 풀을 생성한다 , 생성할때 사용할 팩토리 와 설정을 전달한다.
            GenericObjectPool<PoolableConnection> connectionPool =
                    new GenericObjectPool<>(poolableConnFactory, poolConfig);
            poolableConnFactory.setPool(connectionPool);

            Class.forName("org.apache.commons.dbcp2.PoolingDriver"); // 커넥션 풀을 제공하는 JDBC 드라이버를 등록한다.
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            driver.registerPool("guestbook", connectionPool);
            //커넥션 풀 드라이버에 생성한 커넥션 풀을 등록한다.
            //이 경우 프로그램에서 사용하는 JDBC URL은 "jdbc:apach:commons:dbcp:guestbook"가 된다.
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
