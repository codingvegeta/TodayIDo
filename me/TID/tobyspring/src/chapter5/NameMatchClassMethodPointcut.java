package chapter5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.Method;

public class NameMatchClassMethodPointcut extends NameMatchMethodPointcut
{
    public void setMappedClassName(String mappedClassName)
    {
        this.setClassFilter(new SimpleClassFilter(mappedClassName));
    }

    static class SimpleClassFilter implements ClassFilter
    {
        String mappedName;

        private SimpleClassFilter(String mappedName)
        {
            this.mappedName = mappedName;
        }

        public boolean matches(Class<?> clazz)
        {
            return PatternMatchUtils.simpleMatch(mappedName, clazz.getSimpleName());
        }
    }

}
