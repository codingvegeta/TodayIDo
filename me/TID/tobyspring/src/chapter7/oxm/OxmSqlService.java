package chapter7.oxm;

import chapter1.UserDao;
import chapter7.*;
import chapter7.jaxb.SqlType;
import chapter7.jaxb.Sqlmap;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.Unmarshaller;

import javax.annotation.PostConstruct;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class OxmSqlService implements SqlService
{
    private final OxmSqlReader oxmSqlReader = new OxmSqlReader();

    private SqlRegistry sqlRegistry = new HashMapSqlRegistry();

    private final BaseSqlService baseSqlService = new BaseSqlService();

    public void setSqlRegistry(SqlRegistry sqlRegistry)
    {
        this.sqlRegistry = sqlRegistry;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller)
    {
        oxmSqlReader.setUnmarshaller(unmarshaller);
    }

    public void setSqlmap(Resource resource)
    {
        oxmSqlReader.setSqlmap(resource);
    }

    @PostConstruct
    public void loadSql()
    {
        baseSqlService.setSqlReader(this.oxmSqlReader);
        baseSqlService.setSqlRegistry(this.sqlRegistry);

        baseSqlService.loadSql();
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException
    {
        return baseSqlService.getSql(key);
    }

    private static class OxmSqlReader implements SqlReader
    {
        private Unmarshaller unmarshaller;
        private final static String DEFAULT_SQLMAP_FILE = "/chapter7/oxm/sqlmap.xml";
        private Resource sqlmap = new ClassPathResource("/chapter7/oxm/sqlmap.xml", UserDao.class);

        public void setUnmarshaller(Unmarshaller unmarshaller)
        {
            this.unmarshaller = unmarshaller;
        }

        public void setSqlmap(Resource sqlmap)
        {
            this.sqlmap = sqlmap;
        }

        @Override
        public void read(SqlRegistry sqlRegistry)
        {
            try
            {
                Source source = new StreamSource(sqlmap.getInputStream());
                Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(source);

                for (SqlType sql : sqlmap.getSql())
                {
                    sqlRegistry.registerSql(sql.getKey(), sql.getValue());
                }
            }
            catch (IOException e)
            {
                throw new IllegalArgumentException(sqlmap.getFilename() + "을 가져올 수 없습니다.", e);
            }
        }
    }
}
