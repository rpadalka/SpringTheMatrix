package context;

import matrix.Morpheus;
import matrix.Pill;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by rpadalka on 17.07.16.
 * Lookup-method dependency injection
 */
@Configuration
@ComponentScan(basePackages = "matrix")
public class JavaConfigApplicationContext {

    /*Constructor-based dependency injection*/
    @Bean
    @Scope("prototype")
    public Pill pill() {
        return new Pill("red");
    }

    /*Constructor-based dependency injection*/
    @Bean
    @Scope("singleton")
    public Morpheus morpheus() {
        return new Morpheus("Morpheus") {
            @Override
            protected Pill makePills() {
                return pill();
            }
        };
    }
}
