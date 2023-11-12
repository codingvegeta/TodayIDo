package chapter7;

public class SqlNotFoundException extends RuntimeException
{
    public SqlNotFoundException()
    {
    }

    public SqlNotFoundException(String message)
    {
        super(message);
    }

    public SqlNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SqlNotFoundException(Throwable cause)
    {
        super(cause);
    }

    public SqlNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
