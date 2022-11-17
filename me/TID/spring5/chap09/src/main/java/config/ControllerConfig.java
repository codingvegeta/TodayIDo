package config;

import chap08.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
