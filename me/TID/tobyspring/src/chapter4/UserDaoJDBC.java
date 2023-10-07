package chapter4;

import chapter1.User;
import chapter1.UserDao;
import chapter5.Level;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static chapter5.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;

public class UserDaoJDBC implements UserDao
{
    private RowMapper<User> userMapper = new RowMapper<User>()
    {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException
        {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setLevel(Level.valueOf(rs.getInt("level")));
            user.setLogin(rs.getInt("login"));
            user.setRecommend(rs.getInt("recommend"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    };

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user)
    {
        jdbcTemplate.update("INSERT INTO users(id, name, password, level, login, recommend, email) VALUES (?,?,?,?,?,?,?)",
                user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail());
    }

    public User get(String id)
    {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", new Object[]{id}, userMapper);
    }

    public void deleteAll()
    {
        jdbcTemplate.update("delete from users");

    }

    public int getCount()
    {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) from users", Integer.class);

    }

    public List<User> getAll()
    {
        return jdbcTemplate.query("SELECT * FROM users ORDER BY id", userMapper);
    }

    @Override
    public void update(User user)
    {
        jdbcTemplate.update(
                "UPDATE users SET name = ?, password = ?, level = ?, login = ? ," +
                        "recommend = ?, email = ? WHERE id = ? ", user.getName(), user.getPassword(),
                user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail(), user.getId()
        );
    }
}
