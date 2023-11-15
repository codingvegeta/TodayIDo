package chapter7;

import chapter1.UserDao;
import chapter7.embeddeddb.EmbeddedDbSqlRegistry;
import chapter7.oxm.OxmSqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.sql.DataSource;

@Configuration
public class SqlServiceContext
{
    @Autowired
    SqlMapConfig sqlMapConfig;
    @Bean
    public SqlService sqlService()
    {
        OxmSqlService sqlService = new OxmSqlService();
        sqlService.setSqlRegistry(sqlRegistry());
        sqlService.setUnmarshaller(unmarshaller());
        sqlService.setSqlmap(sqlMapConfig.getSqlMapResource());

        return sqlService;
    }

    @Bean
    public SqlRegistry sqlRegistry()
    {
        EmbeddedDbSqlRegistry registry = new EmbeddedDbSqlRegistry();
        registry.setDataSource(embeddedDatabase());

        return registry;
    }

    @Bean
    public Unmarshaller unmarshaller()
    {
        Jaxb2Marshaller unmarshaller = new Jaxb2Marshaller();
        unmarshaller.setContextPath("chapter7.jaxb");
        return unmarshaller;
    }

    @Bean
    public DataSource embeddedDatabase()
    {
        return new EmbeddedDatabaseBuilder()
                .setName("embeddedDatabase")
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:chapter7/embeddeddb/schema.sql")
                .build();
    }
}
