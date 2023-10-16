package chapter5;

import chapter1.User;
import chapter1.UserDao;
import chapter7.AppContext;
import chapter7.SqlServiceContext;
import chapter7.TestAppContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static chapter5.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static chapter5.UserServiceImpl.MIN_RECOMMEND_FOR_GOLD;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/chapter2/testfactorybean.xml")
@ActiveProfiles("test")
@ContextConfiguration(classes = AppContext.class)
public class UserServiceTest
{
    @Autowired
    DefaultListableBeanFactory bf;
    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;
    @Autowired
    DataSource dataSource;
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    MailSender mailSender;
    @Autowired
    ApplicationContext context;
    @Autowired
    UserService testUserService;

    List<User> users;

    @Test
    public void beans()
    {
        for (String n : bf.getBeanDefinitionNames())
        {
            System.out.println(n + " \t " + bf.getBean(n).getClass().getName());
        }
    }
    @Test
    public void bean()
    {
        assertThat(userService, is(notNullValue()));
    }

    @Before
    public void setUp()
    {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0, "aaa.com"),
                new User("joytouch", "강명성", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0, "bbb.com"),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1, "ccc.com"),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD, "ddd.com"),
                new User("green", "오민규", "p5", Level.GOLD, 100, Integer.MAX_VALUE, "eee.com")
        );
    }

    @Test
    @DirtiesContext
    public void upgradeLevels()
    {
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        MockUserDao mockUserDao = new MockUserDao(this.users);
        userServiceImpl.setUserDao(mockUserDao);

        MockMailSender mockMailSender = new MockMailSender();
        userServiceImpl.setMailSender(mockMailSender);

        userServiceImpl.upgradeLevels();

        List<User> updated = mockUserDao.getUpdated();
        assertThat(updated.size(), is(2));

        checkUserAndLevel(updated.get(0), "joytouch", Level.SILVER);
        checkUserAndLevel(updated.get(1), "madnite1", Level.GOLD);

        List<String> request = mockMailSender.getRequest();
        assertThat(request.size(), is(2));
        assertThat(request.get(0), is(users.get(1).getEmail()));
        assertThat(request.get(1), is(users.get(3).getEmail()));
    }

    private void checkUserAndLevel(User updated, String expectedId, Level expectedLevel)
    {
        assertThat(updated.getId(), is(expectedId));
        assertThat(updated.getLevel(), is(expectedLevel));
    }

    @Test
    public void add()
    {
        userDao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

        assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));
        assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));
    }

    private void checkLevel(User user, Level expectedLevel)
    {
        User userUpdate = userDao.get(user.getId());
        assertThat(userUpdate.getLevel(), is(expectedLevel));
    }

    private void checkLevelUpgrade(User user, boolean upgraded)
    {
        User userUpdate = userDao.get(user.getId());
        if (upgraded)
        {
            assertThat(userUpdate.getLevel(), is(user.getLevel().nextLevel()));
        }
        else
        {
            assertThat(userUpdate.getLevel(), is(user.getLevel()));
        }
    }

    @Test
    public void upgradeAllOrNothing() throws Exception
    {
        userDao.deleteAll();
        for (User user : users) userDao.add(user);

        try
        {
            this.testUserService.upgradeLevels();
            fail("TestUserServiceException expected");
        }
        catch (TestUserServiceException e)
        {

        }

        checkLevelUpgrade(users.get(1), false);
    }

    @Test(expected = TransientDataAccessResourceException.class)
    @DirtiesContext
    public void readOnlyTransactionAttribute()
    {
        testUserService.getAll();
    }

    @Test
    public void transactionSync()
    {
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

        userService.add(users.get(0));
        userService.add(users.get(1));

        assertThat(userDao.getCount(), is(2));

        transactionManager.rollback(txStatus);

        assertThat(userDao.getCount(), is(0));
    }

    @Test
    public void transactionRollbackTest()
    {
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        TransactionStatus txStatus = transactionManager.getTransaction(txDefinition);

        try
        {
            userService.deleteAll();
            userService.add(users.get(0));
            userService.add(users.get(1));
            assertThat(userDao.getCount(), is(2));
        }
        finally
        {
            transactionManager.rollback(txStatus);
            assertThat(userDao.getCount(), is(0));
        }
    }


//    @Test
//    public void advisorAutoProxyCreator()
//    {
//        assertThat(testUserService, is(java.lang.reflect.Proxy.class));
//    }

//    @Test
//    public void mockUpgradeLevels() throws Exception
//    {
//        UserDao mockUserDao = mock(UserDao.class);
//        when(mockUserDao.getAll()).thenReturn(this.users);
//        userServiceImpl.setUserDao(mockUserDao);
//
//        MailSender mockMailSender = mock(MailSender.class);
//        userServiceImpl.setMailSender(mockMailSender);
//
//        userServiceImpl.upgradeLevels();
//        verify(mockUserDao, times(2)).update(any(User.class));
//        verify(mockUserDao, times(2)).update(any(User.class));
//        verify(mockUserDao).update(users.get(1));
//        assertThat(users.get(1).getLevel(), is(Level.BASIC.SILVER));
//        verify(mockUserDao).update(users.get(3));
//        assertThat(users.get(3).getLevel(), is(Level.GOLD));
//
//        ArgumentCaptor<SimpleMailMessage> mailMessageArg = ArgumentCaptor.forClass(SimpleMailMessage.class);
//        verify(mockMailSender, times(2)).send(mailMessageArg.capture());
//        List<SimpleMailMessage> mailMessages = mailMessageArg.getAllValues();
//        assertThat(mailMessages.get(0).getTo()[0], is(users.get(1).getEmail()));
//        assertThat(mailMessages.get(1).getTo()[0], is(users.get(3).getEmail()));
//    }

    public static class TestUserService extends UserServiceImpl
    {
        private String id = "madnite1";

        @Override
        protected void upgradeLevel(User user)
        {
            if (user.getId().equals(this.id)) throw new TestUserServiceException();
            super.upgradeLevel(user);
        }

        @Override
        public List<User> getAll()
        {
            for (User user : super.getAll())
            {
                super.update(user);
            }
            return null;
        }
    }

    static class MockMailSender implements MailSender
    {
        private List<String> request = new ArrayList<String>();

        public List<String> getRequest()
        {
            return request;
        }

        @Override
        public void send(SimpleMailMessage simpleMessage) throws MailException
        {
            request.add(simpleMessage.getTo()[0]);
        }

        @Override
        public void send(SimpleMailMessage... simpleMessages) throws MailException
        {

        }
    }

    static class MockUserDao implements UserDao
    {

        private List<User> users;
        private List<User> updated = new ArrayList<>();

        private MockUserDao(List<User> users)
        {
            this.users = users;
        }

        public List<User> getUpdated()
        {
            return updated;
        }

        @Override
        public void add(User user)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public User get(String id)
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public void deleteAll()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getCount()
        {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<User> getAll()
        {
            return this.users;
        }

        @Override
        public void update(User user)
        {
            updated.add(user);
        }
    }
}
