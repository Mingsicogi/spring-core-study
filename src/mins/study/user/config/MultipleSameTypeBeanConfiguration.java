package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MultipleSameTypeBeanConfiguration {


    @Bean
    @Primary
    public MovieCategory firstMovieCategory() {
        System.out.println("firstMovieCategory load on Spring Container");

        return () -> "firstMovieCategory";
    }

    @Bean
    public MovieCategory secondMovieCategory() {
        System.out.println("secondMovieCategory load on Spring Container");

        return () -> "secondMovieCategory";
    }


    public interface MovieCategory {
        String getMyServiceName();
    }
}
