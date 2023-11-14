package chapter7;

public interface SqlService
{
    String getSql(String key) throws SqlRetrievalFailureException;
}
