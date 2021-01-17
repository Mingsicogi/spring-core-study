package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class EnvironmentAbstractConfiguration {

    @Bean("normalService")
    @Profile("local")
    public NormalService normalService_local() {
        return new NormalService("[LOCAL] Normal Service Start!!!");
    }

    @Bean("normalService")
    @Profile("beta")
    public NormalService normalService_beta() {
        return new NormalService("[BETA] Normal Service Start!!!");
    }

    public static class NormalService {

        private String msg;

        public NormalService(String msg) {
            this.msg = msg;
        }

        public void printer() {
            System.out.println(msg);
        }
    }
}

