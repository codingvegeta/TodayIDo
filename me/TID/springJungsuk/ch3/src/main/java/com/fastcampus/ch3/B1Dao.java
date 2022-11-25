package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class B1Dao {
    @Autowired
    DataSource ds;

    public int insert(int key, int value) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DataSourceUtils.getConnection(ds);
            System.out.println("conn = " + conn);
            pstmt = conn.prepareStatement("insert into b1 values (?,?)");
            pstmt.setInt(1, key);
            pstmt.setInt(2, value);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            close(pstmt);
            DataSourceUtils.releaseConnection(conn, ds);
        }
    }


    private void close(AutoCloseable... acs) {
        for (AutoCloseable ac : acs)
            try {
                if (ac != null) ac.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void deleteAll() throws Exception {
        Connection conn = ds.getConnection();
        String sql = "delete from b1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        close(pstmt);
    }
}
