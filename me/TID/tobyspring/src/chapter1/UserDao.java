package chapter1;

import java.util.List;

public interface UserDao
{
    public void add(final User user);

    public User get(String id);

    public void deleteAll();

    public int getCount();

    public List<User> getAll();

    void update(User user);
}
