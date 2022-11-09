//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jdbc.connection;

import java.io.IOException;
import java.io.StringReader;
import java.sql.DriverManager;
import java.util.Properties;
import javax.management.ObjectName;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInitListener implements ServletContextListener {
    public DBCPInitListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        String poolConfig = sce.getServletContext().getInitParameter("poolConfig");
        Properties prop = new Properties();

        try {
            prop.load(new StringReader(poolConfig));
        } catch (IOException var5) {
            throw new RuntimeException("config load fail", var5);
        }

        this.loadJDBCDriver(prop);
        this.initConnectionPool(prop);
    }

    private void loadJDBCDriver(Properties prop) {
        String driverClass = prop.getProperty("jdbcdriver");

        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException var4) {
            throw new RuntimeException("fail to load JDBC Driver", var4);
        }
    }

    private void initConnectionPool(Properties prop) {
        try {
            String jdbcUrl = prop.getProperty("jdbcUrl");
            String username = prop.getProperty("dbUser");
            String pw = prop.getProperty("dbPass");
            ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);
            PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, (ObjectName)null);
            String validationQuery = prop.getProperty("validationQuery");
            if (validationQuery != null && !validationQuery.isEmpty()) {
                poolableConnFactory.setValidationQuery(validationQuery);
            }

            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRunsMillis(300000L);
            poolConfig.setTestWhileIdle(true);
            int minIdle = this.getIntProperty(prop, "minIdle", 5);
            poolConfig.setMinIdle(minIdle);
            int maxTotal = this.getIntProperty(prop, "maxTotal", 50);
            poolConfig.setMaxTotal(maxTotal);
            GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool(poolableConnFactory, poolConfig);
            poolableConnFactory.setPool(connectionPool);
            Class.forName("org.apache.commons.dbcp2.PoolingDriver");
            PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
            String poolName = prop.getProperty("poolName");
            driver.registerPool(poolName, connectionPool);
        } catch (Exception var14) {
            throw new RuntimeException(var14);
        }
    }

    private int getIntProperty(Properties prop, String propName, int defaultValue) {
        String value = prop.getProperty(propName);
        return value == null ? defaultValue : Integer.parseInt(value);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
