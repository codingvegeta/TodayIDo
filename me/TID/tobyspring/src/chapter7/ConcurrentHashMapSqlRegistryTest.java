package chapter7;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ConcurrentHashMapSqlRegistryTest extends AbstractUpdatableSqlRegistryTest
{
    @Override
    protected UpdatableSqlRegistry createUpdatableSqlRegistry()
    {
        return new ConcurrentHashMapSqlRegistry();
    }
}
