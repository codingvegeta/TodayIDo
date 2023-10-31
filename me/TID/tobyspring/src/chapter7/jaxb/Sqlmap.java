package chapter7.jaxb;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"sql"})
@XmlRootElement(name = "sqlmap")
public class Sqlmap
{
    @XmlElement(required = true)
    protected List<SqlType> sql;

    public List<SqlType> getSql()
    {
        if (sql == null)
        {
            sql = new ArrayList<>();
        }
        return sql;
    }
}
