package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = {"local", "!beta"})
@Configuration
public class EnvironmentAbstractConfiguration {

    @Bean
    public NormalService normalService() {
        return new NormalService();
    }

    public static class NormalService {

        public void printer() {
            System.out.println("Normal Service Start!!!");
        }
    }
}

