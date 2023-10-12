package chapter5;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionHandler implements InvocationHandler
{
    private Object target;
    private PlatformTransactionManager transactionManager;
    private String pattern;

    public void setTarget(Object target)
    {
        this.target = target;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager)
    {
        this.transactionManager = transactionManager;
    }

    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        if (method.getName().startsWith(pattern))
        {
            return invokeTransaction(method, args);
        }else
        {
            return method.invoke(target, args);
        }
    }

    private Object invokeTransaction(Method method, Object args[]) throws Throwable
    {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try
        {
            Object ret = method.invoke(target, args);
            transactionManager.commit(status);
            return ret;
        }
        catch (InvocationTargetException e)
        {
            transactionManager.rollback(status);
            throw e.getTargetException();
        }
    }
}
