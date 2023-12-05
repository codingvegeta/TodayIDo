package vol2.chapter1.simpleconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vol2.chapter1.Hello;

import javax.annotation.PostConstruct;

@Configuration
public class SimpleConfig
{
    @Autowired
    Hello hello;

    @Bean
    Hello hello()
    {
        return new Hello();
    }

    public class Hello{
        @PostConstruct
        public void init(){
            System.out.println("Init");
        }

        public void sayHello()
        {

        }
    }
}
