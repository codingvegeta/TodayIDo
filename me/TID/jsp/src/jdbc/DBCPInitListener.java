package jdbc;

import org.apache.commons.dbcp2.*;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBCPInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
        Properties properties = new Properties();
        try {
            properties.load(new StringReader(poolConfig));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loadJDBCDriver(properties);
        initConnectionPool(properties);
    }

    private void loadJDBCDriver(Properties properties) {
        String driverClass = properties.getProperty("jdbcdriver");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("fail to load JDBC Driver", ex);
        }
    }

    private void initConnectionPool(Properties properties) {
        try {
            String jdbcUrl = properties.getProperty("jdbcUrl");
            String username = properties.getProperty("dbUser");
            String pw = properties.getProperty("dbPass");

            ConnectionFactory connFactory =
                    new DriverManagerConnectionFactory(jdbcUrl, username, pw);

            PoolableConnectionFactory poolableConnectionFactory =
                    new PoolableConnectionFactory(connFactory, null);
            poolableConnectionFactory.setValidationQuery("select 1");

            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRunsMillis(100L * 60L * 5L);
            poolConfig.setTestWhileIdle(true);
            poolConfig.setMinIdle(4);
            poolConfig.setMaxTotal(50);

            GenericObjectPool<PoolableConnection> connectionPool =
                    new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
            poolableConnectionFactory.setPool(connectionPool);

            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:common:dbcp");
            String poolName = properties.getProperty("poolName");
            driver.registerPool(poolName, connectionPool);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
