package mins.study.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource(value = {"classpath:properties/cache.properties", "classpath:properties/redis.properties", "classpath:properties/jdbc.properties",})
public class PropertySourcesConfiguration {

    /**
     * When configuring a PropertySourcesPlaceholderConfigurer using JavaConfig, the @Bean method must be static.
     *
     * @return
     */
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
}
