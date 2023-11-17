package chapter7;

import chapter1.UserDao;
import chapter5.DummyMailSender;
import chapter5.UserService;
import chapter5.UserServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSender;

@Configuration
@Profile("test")
public class TestAppContext
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
