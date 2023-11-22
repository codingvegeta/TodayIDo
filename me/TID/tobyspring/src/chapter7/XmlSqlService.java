package chapter7;


import chapter1.UserDao;
import chapter7.jaxb.SqlType;
import chapter7.jaxb.Sqlmap;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class XmlSqlService implements SqlService,SqlRegistry,SqlReader
{
    // --------- SqlProvider -----------
    private SqlReader sqlReader;
    private SqlRegistry sqlRegistry;

    public void setSqlReader(SqlReader sqlReader)
    {
        this.sqlReader = sqlReader;
    }

    public void setSqlRegistry(SqlRegistry sqlRegistry)
    {
        this.sqlRegistry = sqlRegistry;
    }

    // --------- SqlRegistry ---------
    private Map<String, String> sqlMap = new HashMap<>();

    @Override
    public void registerSql(String key, String sql)
    {
        sqlMap.put(key, sql);
    }

    @Override
    public String findSql(String key) throws SqlNotFoundException
    {
        String sql = sqlMap.get(key);
        if (sql == null)
        {
            throw new SqlNotFoundException(key + "에 대한 SQL을 찾을 수 없습니다.");
        }
        return sql;
    }

    // ------ SqlReader ----------
    private String sqlmapFile;

    public void setSqlmapFile(String sqlmapFile)
    {
        this.sqlmapFile = sqlmapFile;
    }

    @Override
    public void read(SqlRegistry sqlRegistry)
    {
        String contextPath = Sqlmap.class.getPackage().getName();
        try
        {
            JAXBContext context = JAXBContext.newInstance(contextPath);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStream is = UserDao.class.getResourceAsStream(sqlmapFile);
            Sqlmap sqlmap = (Sqlmap) unmarshaller.unmarshal(is);
            for (SqlType sql : sqlmap.getSql())
            {
                sqlRegistry.registerSql(sql.getKey(), sql.getValue());
            }
        }
        catch (JAXBException e)
        {
            throw new RuntimeException(e);
        }
    }

    // --------- SqlService ----------

    @PostConstruct
    public void loadSql()
    {
        sqlReader.read(sqlRegistry);
    }

    @Override
    public String getSql(String key) throws SqlRetrievalFailureException
    {
        try
        {
            return sqlRegistry.findSql(key);
        }
        catch (SqlNotFoundException e)
        {
            throw new SqlRetrievalFailureException(e);
        }
    }


}
