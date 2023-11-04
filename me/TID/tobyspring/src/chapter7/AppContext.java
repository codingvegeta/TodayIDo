package chapter7;

import chapter1.UserDao;
import chapter5.DummyMailSender;
import chapter5.UserService;
import chapter5.UserServiceTest;
import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "chapter7")
@Import({SqlServiceContext.class, AppContext.TestAppContext.class, AppContext.ProductionAppContext.class})
@PropertySource("/chapter7/database.properties")
public class AppContext implements SqlMapConfig
{

    @Value("${db.driverClass}")Class<? extends java.sql.Driver> driverClass;
    @Value("${db.url}") String url;
    @Value("${db.username}")String username;
    @Value("${db.password}") String password;

    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource()
    {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public TransactionManager transactionManager()
    {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }

    @Override
    public Resource getSqlMapResource()
    {
        return new ClassPathResource("/chapter7/oxm/sqlmap.xml", UserDao.class);
    }

    @Configuration
    @Profile("test")
    static class TestAppContext
    {
        @Bean
        public UserService testUserService()
        {
            return new UserServiceTest.TestUserService();
        }

        @Bean
        public MailSender mailSender()
        {
            return new DummyMailSender();
        }
    }

    @Configuration
    @Profile("product")
    static class ProductionAppContext
    {

        @Bean
        public MailSender mailSender()
        {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("localhost");
            return mailSender;
        }
    }

}
