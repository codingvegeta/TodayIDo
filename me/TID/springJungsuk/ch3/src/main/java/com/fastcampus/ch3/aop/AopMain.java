package com.fastcampus.ch3.aop;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception {

        MyAdvice myAdvice = new MyAdvice();

        Class myclass = Class.forName("com.fastcampus.ch3.aop.MyClass");
        Object obj = myclass.newInstance();

        for (Method m : myclass.getDeclaredMethods()) {
            myAdvice.invoke(m, obj, null);
        }

    }
}

class MyAdvice {
    Pattern p = Pattern.compile("a.*");

    boolean matches(Method m) {
        Matcher matcher = p.matcher(m.getName());
        return matcher.matches();
    }

    void invoke(Method m, Object obj, Object... args) throws Exception {
        if (matches(m))
            System.out.println("[before]{");

            m.invoke(obj, args);

        if (matches(m))
            System.out.println("}[after]");
    }
}

class MyClass {
    @Transactional
    void aaa() {
        System.out.println("aaa() is called");
    }

    void aaa2() {
        System.out.println("aaa2() is called");
    }

    void bbb() {
        System.out.println("bbb() is called");
    }

}
