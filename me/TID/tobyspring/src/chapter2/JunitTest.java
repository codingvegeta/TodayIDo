package chapter2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "junit.xml")
public class JunitTest
{
    @Autowired
    ApplicationContext context;
    static Set<JunitTest> testObject = new HashSet<>();
    static ApplicationContext contextObject = null;

    @Test
    public void test1()
    {
//        Assert.assertThat(this, is(not(sameInstance(testObject))));
        Assert.assertThat(testObject, not(hasItem(this)));
//        testObject = this;
        testObject.add(this);

        assertThat(contextObject == null || contextObject == this.context, is(true));
        contextObject = this.context;
    }

    @Test
    public void test2()
    {
//        Assert.assertThat(this, is(not(sameInstance(testObject))));
        assertThat(testObject, not(hasItem(this)));
//        testObject = this;
        testObject.add(this);

        assertThat(contextObject == null || contextObject == this.context, is(true));
        contextObject = this.context;
    }

    @Test
    public void test3()
    {
//        Assert.assertThat(this, is(not(sameInstance(testObject))));
        assertThat(testObject, not(hasItem(this)));
//        testObject = this;
        testObject.add(this);

//        assertThat(contextObject == null || contextObject == this.context, is(true));
        assertThat(contextObject, either(is(nullValue())).or(is(this.context)));
        contextObject = this.context;
    }
}
