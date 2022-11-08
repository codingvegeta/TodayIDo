package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class MySQLDriverLoader extends HttpServlet { //HttpServlet 클래스를 상속한다.

    public void init(ServletConfig config) throws ServletException{ //서블릿을 초기화할 때 호출되는 init()메서드를 구현한다.
        try {
            Class.forName("com.mysql.jdbc.Driver"); //MySQL JDBC 드라이버를 로딩한다.
        } catch (Exception exception) {
            throw new ServletException(exception); // 드라이버 로딩 과정에서 문제가 있을경우 익셉션을 발생시킨다.
        }
    }
}
