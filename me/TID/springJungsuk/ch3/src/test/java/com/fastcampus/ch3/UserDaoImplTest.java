package com.fastcampus.ch3;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDaoImplTest extends TestCase {
    @Autowired
    UserDao userDao;

    @Test
    public void testDeleteUser() {
    }

    @Test
    public void testSelectUser() {
    }

    @Test
    public void testInsertUser() {
    }

    @Test
    public void testUpdateUser()throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2021, 1, 1);

        userDao.deleteAll();
        User user = new User("asdf", "1234", "abc", "aaa@aaa.com", new Date(cal.getTimeInMillis()), "fb", new Date(cal.getTimeInMillis()));
        int rowCnt = userDao.insertUser(user);
        assertTrue(rowCnt == 1);

        user.setPwd("4321");
        user.setEmail("bbb@bbb.com");
        rowCnt = userDao.updateUser(user);
        assertTrue(rowCnt == 1);

        User user2 = userDao.selectUser(user.getId());
        System.out.println("user = " + user);
        System.out.println("user2 = " + user2);
        assertTrue(user.equals(user2));

    }
}