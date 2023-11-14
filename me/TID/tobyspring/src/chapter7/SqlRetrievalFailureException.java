package chapter7;

public class SqlRetrievalFailureException extends RuntimeException
{
    public SqlRetrievalFailureException()
    {
    }

    public SqlRetrievalFailureException(String message)
    {
        super(message);
    }

    public SqlRetrievalFailureException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SqlRetrievalFailureException(Throwable cause)
    {
        super(cause);
    }

    public SqlRetrievalFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
