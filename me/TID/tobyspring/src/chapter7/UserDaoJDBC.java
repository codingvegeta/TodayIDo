package chapter7;

import chapter1.User;
import chapter1.UserDao;
import chapter5.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoJDBC implements UserDao
{
    @Autowired
    private SqlService sqlService;

    public void setSqlService(SqlService sqlService)
    {
        this.sqlService = sqlService;
    }

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

    @Autowired
    public void setDataSource(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user)
    {
//        jdbcTemplate.update(sqlAdd,
        jdbcTemplate.update(sqlService.getSql("userAdd"),
                user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail());
    }

    public User get(String id)
    {
        return jdbcTemplate.queryForObject(sqlService.getSql("userGet"), new Object[]{id}, userMapper);
    }

    public void deleteAll()
    {
        jdbcTemplate.update(sqlService.getSql("userDeleteAll"));

    }

    public int getCount()
    {
        return jdbcTemplate.queryForObject(sqlService.getSql("userGetCount"), Integer.class);
    }

    public List<User> getAll()
    {
        return jdbcTemplate.query(sqlService.getSql("userGetAll"), userMapper);
    }

    @Override
    public void update(User user)
    {
        jdbcTemplate.update(
                sqlService.getSql("userUpdate"), user.getName(), user.getPassword(),
                user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getEmail(), user.getId()
        );
    }
}
