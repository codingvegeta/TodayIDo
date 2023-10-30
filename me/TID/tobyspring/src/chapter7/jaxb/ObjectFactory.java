package chapter7.jaxb;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory
{
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: springbook.issuetracker.sqlprovider.jaxb
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SqlType }
     *
     */
    public SqlType createSqlType() {
        return new SqlType();
    }

    /**
     * Create an instance of {@link Sqlmap }
     *
     */
    public Sqlmap createSqlmap() {
        return new Sqlmap();
    }
}
