package chapter7.embeddeddb;

import chapter7.AbstractUpdatableSqlRegistryTest;
import chapter7.SqlUpdateFailureException;
import chapter7.UpdatableSqlRegistry;
import org.junit.After;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.HashMap;

import static junit.framework.Assert.fail;

public class EmbeddedDbRegistryTest extends AbstractUpdatableSqlRegistryTest
{
    EmbeddedDatabase db;
    @Override
    protected UpdatableSqlRegistry createUpdatableSqlRegistry()
    {
        db = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:chapter7/embeddeddb/schema.sql")
                .build();


        EmbeddedDbSqlRegistry embeddedDbSqlRegistry = new EmbeddedDbSqlRegistry();
        embeddedDbSqlRegistry.setDataSource(db);
        return embeddedDbSqlRegistry;
    }

    @After
    public void tearDown()
    {
        db.shutdown();
    }

    @Test
    public void transactionalUpdate()
    {
        checkFindResult("SQL1", "SQL2", "SQL3");

        HashMap<String, String> sqlmap = new HashMap<>();
        sqlmap.put("KEY1", "Modified1");
        sqlmap.put("KEY9999!@#$", "Modified9999");

        try
        {
            sqlRegistry.updateSql(sqlmap);
            fail();
        }
        catch (SqlUpdateFailureException e)
        {
            checkFindResult("SQL1", "SQL2", "SQL3");
        }
    }
}
