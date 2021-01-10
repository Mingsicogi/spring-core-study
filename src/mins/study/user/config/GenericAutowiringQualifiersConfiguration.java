package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericAutowiringQualifiersConfiguration {

    @Bean
    public StringStorage stringStorage() {
        return new StringStorage();
    }

    @Bean
    public IntegerStorage integerStorage() {
        return new IntegerStorage();
    }
}
