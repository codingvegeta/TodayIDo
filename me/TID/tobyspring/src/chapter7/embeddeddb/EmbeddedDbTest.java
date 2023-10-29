package chapter7.embeddeddb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class EmbeddedDbTest
{
    EmbeddedDatabase db;
    JdbcTemplate jdbcTemplate;

    @Before
    public void setUp()
    {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:/chapter7/embeddeddb/schema.sql")
                .addScript("classpath:/chapter7/embeddeddb/data.sql")
                .build();

        jdbcTemplate = new JdbcTemplate(db);
    }

    @After
    public void tearDown()
    {
        db.shutdown();
    }

    @Test
    public void initData()
    {
        assertThat(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM sqlmap", Integer.class), is(2));

        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM sqlmap ORDER BY key_");
        assertThat((String) list.get(0).get("key_"), is("KEY1"));
        assertThat((String) list.get(0).get("sql_"), is("SQL1"));
        assertThat((String) list.get(1).get("key_"), is("KEY2"));
        assertThat((String) list.get(1).get("sql_"), is("SQL2"));
    }

    @Test
    public void insert()
    {
        jdbcTemplate.update("INSERT INTO sqlmap(key_,sql_) VALUES (?,?)", "KEY3", "SQL3");

        assertThat(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM sqlmap", Integer.class), is(3));
    }
}
