package chapter1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker
{
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost/springbook", "spring","book"
        );
        return c;
    }
}
