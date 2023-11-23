package vol2.chapter1.myproject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "vol2.chapter1.myproject",
excludeFilters = @ComponentScan.Filter(Configuration.class))
public class AppConfig
{
}
