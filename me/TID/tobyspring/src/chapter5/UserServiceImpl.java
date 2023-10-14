package chapter5;

import chapter1.User;
import chapter1.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService
{
    public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_FOR_GOLD = 30;

    @Autowired
    UserDao userDao;

    @Autowired
    MailSender mailSender;

    @Override
    public void add(User user)
    {
        if (user.getLevel() == null) user.setLevel(Level.BASIC);
        userDao.add(user);
    }

    @Override
    public User get(String id)
    {
        return userDao.get(id);
    }

    @Override
    public List<User> getAll()
    {
        return userDao.getAll();
    }

    @Override
    public void deleteAll()
    {
        userDao.deleteAll();
    }

    @Override
    public void update(User user)
    {
        userDao.update(user);
    }

    @Override
    public void upgradeLevels()
    {
        List<User> users = userDao.getAll();
        for (User user : users)
        {
            if (canUpgradeLevel(user))
            {
                upgradeLevel(user);
            }
        }
    }

    private boolean canUpgradeLevel(User user)
    {
        Level currentLevel = user.getLevel();
        switch (currentLevel)
        {
            case BASIC:
                return (user.getLogin() >= MIN_LOGCOUNT_FOR_SILVER);
            case SILVER:
                return (user.getRecommend() >= MIN_RECOMMEND_FOR_GOLD);
            case GOLD:
                return false;
            default:
                throw new IllegalArgumentException("Unknown Level : " + currentLevel);
        }
    }

    protected void upgradeLevel(User user)
    {
        user.upgradeLevel();
        userDao.update(user);
        sendUpgradeEMail(user);
    }

    private void sendUpgradeEMail(User user)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("useradmin@ksug.org");
        mailMessage.setSubject("Upgrade 안내");
        mailMessage.setText("사용장님의 등급이 " + user.getLevel().name() + "으로 변경되었습니다.");

        mailSender.send(mailMessage);
    }

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    public void setMailSender(MailSender mailSender)
    {
        this.mailSender = mailSender;
    }
}
